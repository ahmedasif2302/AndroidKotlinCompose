package com.example.giftcard.network.module

import com.example.giftcard.network.api.IProducts
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "https://fakestoreapi.com"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create(Gson())
        ).build()

    @Provides
    fun provideProductApi(retrofit: Retrofit): IProducts =
        retrofit.create<IProducts>(IProducts::class.java)
}