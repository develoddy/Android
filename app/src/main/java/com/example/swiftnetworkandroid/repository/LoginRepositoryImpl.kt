package com.example.swiftnetworkandroid.repository

import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.data.remote.LoginDataSource
import retrofit2.Call
import retrofit2.http.Body

//TODO: RepositoyImpl -> DataSource
class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {
    override suspend fun getToken( email:String, password:String  ): ResultLogin = dataSource.getToken( email, password )
}