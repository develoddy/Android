package com.example.swiftnetworkandroid.repository.home

import com.example.swiftnetworkandroid.data.model.UserPost
import com.example.swiftnetworkandroid.data.remote.home.HomeDataSource

class HomeRepositoryImpl(private val dataSource: HomeDataSource): HomeRepository {
    override suspend fun getUserPost(token: String?): UserPost = dataSource.getUserPost(token)
}