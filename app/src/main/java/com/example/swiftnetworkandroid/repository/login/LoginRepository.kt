package com.example.swiftnetworkandroid.repository.login

import com.example.swiftnetworkandroid.data.model.ResultLogin

// TODO: INTERFACE REPOSITORY
interface LoginRepository {
    suspend fun getToken(email:String, password:String): ResultLogin
}