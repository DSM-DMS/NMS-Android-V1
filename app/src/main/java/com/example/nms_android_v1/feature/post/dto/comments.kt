package com.example.nms_android_v1.feature.post.dto

data class comments(
    val id : Int,
    val writer: writer,
    val content : String,
    val created_date: String,
    val replies: replies
)