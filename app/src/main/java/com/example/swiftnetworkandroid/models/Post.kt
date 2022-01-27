package com.example.swiftnetworkandroid.models

data class Post (
     val postid: String="",
     val username:String = "",
     val thumbnailImage: String="",
     val likeCount: String = "",
     val description: String = "",
     val commentsCount: String = "0",
     val publisher: String=""

) {
     var caption: String = ""


}