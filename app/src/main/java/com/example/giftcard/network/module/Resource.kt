package com.example.giftcard.network.module

enum class Status {
    NONE,
    SUCCESS,
    ERROR,
    LOADING
}

data class Error(val message: String, val code: Int? = null)
data class Resource<out T>(val data: T?, val status: Status, val error: Error) {

    companion object {
        fun <T> success(data: T?): Resource<T> =
            Resource(data = data, status = Status.SUCCESS, error = Error(message = "", code = -1))

        fun <T> error(data: T? = null, message: String?): Resource<T> = Resource(
            data = data,
            status = Status.ERROR,
            error = Error(message = message ?: "An error occurred", code = -1)
        )

        fun <T> loading(data: T? = null, error: Error? = null): Resource<T> = Resource(
            data = data,
            status = Status.LOADING,
            error = error ?: Error(message = "Loading", code = -1)
        )
    }
}