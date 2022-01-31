package com.example.swiftnetworkandroid.data.model

//TODO: Transforma un objeto Json a un objeto User, por ejemplo.
data class ResultLogin (
    val token: String,
    val token_type: String,
    val expires_in: Int,
    val usertoken: User,
    //val usertoken: List<User> = listOf(),
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val email_verified_at: String,
    val id_count: Int,
    val created_at: String,
    val updated_at: String
)
