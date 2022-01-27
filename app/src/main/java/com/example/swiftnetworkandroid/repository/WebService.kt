package com.example.swiftnetworkandroid.repository

import com.example.swiftnetworkandroid.application.AppConstants
import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.google.gson.GsonBuilder
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


//TODO: WebService será el encargado de traer la información del servidor.
interface WebService {

    //@Headers("Content-Type: application/json", "X-Requested-With: XMLHttpRequest", "Authorization: Bearer 82773728378278233782")
    @Headers("Accept:Application/json", "Content-Type: application/json")
    //@POST("login/")
    //suspend fun getToken( @Body login: Login ): Call<ResultLogin>
    //suspend fun getToken( @Body login: Login ): ResultLogin

    @POST("login")
    suspend fun getToken(@Query("email") email: String,
                         @Query( "password") password: String): ResultLogin
}


object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory((GsonConverterFactory.create(GsonBuilder().create())))
            .build().create(WebService::class.java)
    }
}