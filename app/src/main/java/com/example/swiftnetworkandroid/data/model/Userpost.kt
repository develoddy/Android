package com.example.swiftnetworkandroid.data.model

data class UserPost(
    val status: Boolean = false,
    val userpost: List<post> = listOf()
)

data class post(
    val id: Int = -1,
    val title: String = "",
    val content: String = "",
    val lat: Int = 0,
    val lng: Int = 0,
    val start_at: String = "",
    val finish_at: String = "",
    val receptor_type_id: Int = 0,
    val author_ref_id: Int = 0,
    val receptor_ref_id: Int = 0,
    val postt_type_id: Int = 0,
    val nivel_id: Int = 0,
    val created_at: String = "",
    val updated_at: String = "",
    val id_post_type: Int = 0,
    val comments: List<Comments> = listOf(),
)

data class Comments(
    val id: Int = 0,
    val type_id: String = "",
    val ref_id: String = "",
    val content: String = "",
    val users_id: String = "",
    val comentario_id: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val user: List<User> = listOf(),
)

