package com.example.swiftnetworkandroid.data.remote.login

import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.repository.WebService

//TODO: DATASOURCE
class LoginDataSource( private val webService: WebService) {

    /** SE LLAMA AL WEBSERVICE **/
    suspend fun getToken(email:String, password:String  ): ResultLogin = webService.getToken( email, password )
}