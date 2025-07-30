package com.example.giftcard.network.dataRepository

import com.example.giftcard.model.UsersItem
import com.example.giftcard.network.api.UsersApiService
import retrofit2.Response
import javax.inject.Inject


class UserDataRepository @Inject constructor(val usersApiService: UsersApiService) {
    suspend fun getAllUsers(): Response<List<UsersItem>?> = usersApiService.getAllUsers()
}