package com.example.swiftnetworkandroid.data.model

import com.google.gson.annotations.SerializedName

data class UserPost(
    val status: Boolean,
    val userpost: List<Post> = listOf()
)

data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val lat: Int,
    val lng: Int,
    val start_at: String,
    val finish_at: String,
    val receptor_type_id: Int,
    val author_ref_id: Int,
    val receptor_ref_id: Int,
    val postt_type_id: Int,
    val nivel_id: Int,
    val created_at: String,
    val updated_at: String,
    val id_post_type: Int,
    val comments: List<Comments> = listOf(),
    val likes: List<Likes> = listOf(),
    val taggeds: List<Taggeds> = listOf(),
    @SerializedName("user_author") val user_author: UserAuthor,
    val post_image: List<PostImage> = listOf(),
    val post_type:  PostType
)


data class Comments(
    val id: Int,
    val type_id: String,
    val ref_id: String,
    val content: String,
    val users_id: String,
    val comentario_id: String,
    val created_at: String,
    val updated_at: String,
    val user: User)

data class Likes(
    val id: Int,
    val type_id: Int,
    val ref_id: Int,
    val users_id: Int,
    val created_at: String,
    val updated_at: String,
    val userlike: User)

data class Taggeds(
    val id : Int,
    val name: String,
    val last: String,
    val username: String,
    val bio: String,
    val profile_picture: String,
    val day_of_birth: String,
    val public_email: String,
    val join_date: String,
    val country_id: Int,
    val image: String,
    val image_header: String,
    val title: String,
    val likes: String,
    val dislikes: String,
    val address: String,
    val phone: String,
    val users_id: Int,
    val nivel_id: Int,
    val sentimental_id: Int,
    val imagen_bin: String,
    val valor: String,
    val id_post: Int,
    val id_gender: Int,
    val id_count: Int,
    val created_at: String,
    val updated_at: String,
    val gender: Gender
)

data class Gender(
    val id: Int,
    val gender: String,
    val created_at: String,
    val updated_at: String,
)

data class UserAuthor(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val email_verified_at: String,
    val id_count: Int,
    val created_at: String,
    val updated_at: String,
    val count: Count,
    val profile: Profile
)

data class Count(
    val id: Int,
    val followers: Int,
    val following: Int,
    val posts: Int,
    val created_at: String,
    val updated_at: String,
)

data class Profile(
    val id: Int,
    val day_of_birth: String,
    val gender: String,
    val image: String,
    val image_header: String,
    val title: String,
    val bio: String,
    val likes: String,
    val dislikes: String,
    val address: String,
    val phone: String,
    val public_email: String,
    val data: String,
    val valor: String,
    val users_id: Int,
    val country_id: Int,
    val nivel_id: Int,
    val sentimental_id: Int,
    val created_at: String,
    val updated_at: String,
)

data class PostImage(
    val post_id: Int,
    val image_id: Int,
    val created_at: String,
    val updated_at: String,
    val image: Image
)

data class Image(
    val id: Int,
    val src: String,
    val title: String,
    val content: String,
    val image_bin: String,
    val album_id: Int,
    val users_id: Int,
    val nivel_id: Int,
    val created_at: String,
    val updated_at: String,
)

data class PostType(
    val id: Int,
    val photo: String,
    val video: String,
    val created_at: String,
    val updated_at: String,
)