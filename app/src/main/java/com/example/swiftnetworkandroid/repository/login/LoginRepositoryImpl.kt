package com.example.swiftnetworkandroid.repository.login

import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.data.remote.login.LoginDataSource

//TODO: IMPLEMENTACION DE LA INTERFAZ DEL REPOSITORY
class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {

    /** SE LLAMA AL REMOTE DATA SOURCE **/
    override suspend fun getToken(email: String, password: String): ResultLogin = dataSource.getToken(email, password)
}