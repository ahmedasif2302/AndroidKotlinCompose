package com.example.giftcard.network.api

import com.example.giftcard.model.ProductsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IProducts {
    @GET("/products")
    suspend fun getProducts(): Response<List<ProductsItem>>

    @GET("/products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductsItem?>
}