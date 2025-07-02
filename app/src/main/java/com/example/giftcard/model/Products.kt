package com.example.giftcard.model


data class Rating(
    val rate: Any? = null,
    val count: Int? = null
)

data class ProductsItem(
    val image: String? = null,
    val price: Any? = null,
    val rating: Rating? = null,
    val description: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val category: String? = null
)

