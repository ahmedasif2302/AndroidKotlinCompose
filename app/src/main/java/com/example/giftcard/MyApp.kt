package com.example.giftcard

import android.app.Application
import android.util.Log
import com.example.giftcard.network.IProducts
import com.google.gson.Gson
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class MyApp : Application() {
    lateinit var retrofit: Retrofit;
    override fun onCreate() {
        super.onCreate()
        makeProductCallById(1)
    }


    private fun makeProductsCall() {
        GlobalScope.launch {
            retrofit =
                Retrofit.Builder().baseUrl("https://fakestoreapi.com").addConverterFactory(
                    GsonConverterFactory.create(Gson())
                ).build()
            val productService = retrofit.create(IProducts::class.java)
            val response = productService.getProducts().execute()
            val products = response.body()
            Log.d("MainActivity", "Products: $products")
        }
    }

    private fun makeProductCallById(id: Int) {
        GlobalScope.launch {
            retrofit =
                Retrofit.Builder().baseUrl("https://fakestoreapi.com").addConverterFactory(
                    GsonConverterFactory.create(Gson())
                ).build()
            val productService = retrofit.create(IProducts::class.java)
            val response = productService.getProductById(id).execute()
            val products = response.body()
            Log.d("MainActivity", "Products By id: $products")
        }
    }
}