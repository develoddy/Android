package com.example.swiftnetworkandroid.repository

import com.example.swiftnetworkandroid.application.AppConstants
import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


// TODO: WEBSERVICE SERÁ EL ENCARGADO DE TRAER LA INFORMACIÓN DEL SERVIDOR.
interface WebService {

    // TODO: LOGIN
    @Headers("Accept:Application/json", "Content-Type: application/json")
    @POST("login")
    suspend fun getToken(@Query("email") email: String, @Query( "password") password: String): ResultLogin


    // TODO: HOME
    suspend fun getUserPost()


    // TODO: PROFILE
    suspend fun getUserpost()
}


object RetrofitClient {
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory((GsonConverterFactory.create(GsonBuilder().create())))
            .build().create(WebService::class.java)
    }
}

