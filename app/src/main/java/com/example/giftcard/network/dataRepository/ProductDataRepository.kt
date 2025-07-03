package com.example.giftcard.network.dataRepository

import android.util.Log
import com.example.giftcard.network.dataSource.ProductDataSource
import com.example.giftcard.network.module.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDataRepository @Inject constructor(val productDataSource: ProductDataSource) {

    suspend fun makeProductsCall() = makeSafeApiCall { productDataSource.getProducts() }

    private suspend fun <T> makeSafeApiCall(api: suspend () -> Resource<T?>) = flow<Resource<T?>> {
        try {
            emit(Resource.loading())
            val response = api.invoke()
            Log.d("Data Repository", "Response: $response")
            emit(Resource.success(data = response.data))
        } catch (e: Exception) {
            Log.e("Data Repository", "Error: ${e.message}", e)
            emit(Resource.error(data = null, message = e.message ?: "An error occurred"))
        }
    }


}