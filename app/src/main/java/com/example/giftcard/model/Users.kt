package com.example.giftcard.model

data class Users(
	val users: List<UsersItem?>? = null
)

data class Address(
	val zipcode: String? = null,
	val number: Int? = null,
	val city: String? = null,
	val street: String? = null,
	val geolocation: Geolocation? = null
)

data class UsersItem(
	val password: String? = null,
	val address: Address? = null,
	val phone: String? = null,
	val v: Int? = null,
	val name: Name? = null,
	val id: Int? = null,
	val email: String? = null,
	val username: String? = null
)

data class Geolocation(
	val lat: String? = null,
	val jsonMemberLong: String? = null
)

data class Name(
	val firstname: String? = null,
	val lastname: String? = null
)

