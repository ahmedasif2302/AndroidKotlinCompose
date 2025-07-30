package com.example.giftcard.network.api

import com.example.giftcard.model.UsersItem
import retrofit2.Response
import retrofit2.http.GET

interface UsersApiService {
    @GET("/users")
    suspend fun getAllUsers(): Response<List<UsersItem>?>
}

