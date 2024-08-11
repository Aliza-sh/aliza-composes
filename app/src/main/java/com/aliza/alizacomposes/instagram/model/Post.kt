package com.aliza.alizacomposes.instagram.model

data class Post(
    val user: User,
    val location: String,
    val postPic: Int,
    val likeCount: Int,
    val caption: String,
    val commentCount: Int
)
