package com.example.swiftnetworkandroid.repository

import com.example.swiftnetworkandroid.data.model.ResultLogin
import retrofit2.Call

//TODO: Será el encargado de ir a buscar la información
interface LoginRepository {
    suspend fun getToken(email:String, password:String): ResultLogin
}