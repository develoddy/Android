package com.example.swiftnetworkandroid.repository.login

import com.example.swiftnetworkandroid.data.model.ResultLogin

// TODO: INTERFACE REPOSITORY
interface LoginRepository {

    /**  SERA EL ENCARGADO DE IR A BUSCAR LA INFORMACIÓN **/
    suspend fun getToken(email:String, password:String): ResultLogin
}