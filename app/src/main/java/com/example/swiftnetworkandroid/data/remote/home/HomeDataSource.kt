package com.example.swiftnetworkandroid.data.remote.home

import com.example.swiftnetworkandroid.data.model.UserPost
import com.example.swiftnetworkandroid.webservice.WebService

class HomeDataSource(private val webService: WebService) {
    suspend fun getUserPost(token:String?): UserPost = webService.getUserPost(token)
}