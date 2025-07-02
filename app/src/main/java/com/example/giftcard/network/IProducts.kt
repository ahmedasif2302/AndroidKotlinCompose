package com.example.giftcard.network

import com.example.giftcard.model.ProductsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IProducts {
    @GET("/products")
    fun getProducts(): Call<List<ProductsItem>>

    @GET("/products/{id}")
    fun getProductById(@Path("id") id: Int): Call<ProductsItem?>
}