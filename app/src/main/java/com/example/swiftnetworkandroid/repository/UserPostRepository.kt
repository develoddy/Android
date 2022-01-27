package com.example.swiftnetworkandroid.repository

import com.example.swiftnetworkandroid.data.model.UserPost

//TODO: Definir los metodos que vamos a usar luego en el Data Source.
interface UserPostRepository {
    suspend fun getUserPost(): UserPost
}