package com.example.swiftnetworkandroid.repository.home

import com.example.swiftnetworkandroid.data.model.UserPost

interface HomeRepository {
    suspend fun getUserPost(token:String?): UserPost
}