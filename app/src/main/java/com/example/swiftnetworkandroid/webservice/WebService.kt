package com.example.swiftnetworkandroid.webservice

import com.example.swiftnetworkandroid.application.AppConstants
import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.data.model.UserPost
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


// TODO: WEBSERVICE
interface WebService {

    // TODO: LOGIN
    @Headers("Accept:Application/json", "Content-Type: application/json")
    @POST("login")
    suspend fun getToken(@Query("email") email: String, @Query( "password") password: String): ResultLogin


    // TODO: HOME
    @Headers("Content-Length:0", "Host: develoddy.com", "User-Agent:PostmanRuntime/7.29.0", "Accept: */*")
    @POST("home/userpost")
    suspend fun getUserPost(@Header("Authorization") token: String?): UserPost
}


object RetrofitClient {
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory((GsonConverterFactory.create(GsonBuilder().create())))
            .build().create(WebService::class.java)
    }
}

