package com.example.swiftnetworkandroid.data.remote

import com.example.swiftnetworkandroid.data.model.UserPost

//TODO: Llama al servidor para traer la información.
class UserPostDataSource {

    fun getUserPost(): UserPost {
        return UserPost()
    }
}