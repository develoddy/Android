package com.example.swiftnetworkandroid.scenes.omboarding.login.data

import com.example.swiftnetworkandroid.data.model.ResultLogin
import com.example.swiftnetworkandroid.data.remote.LoginDataSource
import com.example.swiftnetworkandroid.scenes.omboarding.login.LoginContract
import com.example.swiftnetworkandroid.scenes.omboarding.login.LoginRemoteDataManager

class MainRepo(private val dataSource: LoginDataSource) : LoginContract.Repo {
//class MainRepo() : LoginContract.Repo {

    //private var dataSource: LoginDataSource = LoginDataSource()

    override suspend fun getToken(email: String, password: String): ResultLogin =  dataSource.getToken(email, password)
}