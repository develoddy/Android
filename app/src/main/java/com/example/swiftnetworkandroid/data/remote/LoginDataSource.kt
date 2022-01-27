package com.example.swiftnetworkandroid.data.remote

import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.repository.WebService
import retrofit2.Call

//TODO: DataSource -> WebService
class LoginDataSource( private val webService: WebService ) {

    suspend fun getToken( email:String, password:String  ): ResultLogin = webService.getToken( email, password )

}