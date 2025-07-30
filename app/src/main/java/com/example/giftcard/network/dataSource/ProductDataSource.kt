package com.example.giftcard.network.dataSource

import android.util.Log
import com.example.giftcard.model.ProductsItem
import com.example.giftcard.network.api.IProducts
import com.example.giftcard.network.module.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDataSource @Inject constructor(private val productApi: IProducts) {

    suspend fun getProducts(): Resource<List<ProductsItem>?> {
        return withContext(Dispatchers.IO) {
            val response = productApi.getProducts()
            Log.d("ProductDataSource", "Response: $response")
            if (response.isSuccessful) {
                Resource.success(data = response.body())
            } else {
                Resource.error(data = null, message = "Error fetching products")
            }
        }
    }


    suspend fun getProductById(id: Int): Resource<ProductsItem?> {
        return withContext(Dispatchers.IO) {
            val response = productApi.getProductById(id)
            Log.d("ProductDataSource", "Response: $response")
            if (response.isSuccessful) {
                Resource.success(data = response.body())
            } else {
                Resource.error(data = null, message = "Error fetching products")
            }
        }
    }

}