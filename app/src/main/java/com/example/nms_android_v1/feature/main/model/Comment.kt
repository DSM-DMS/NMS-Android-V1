package com.example.nms_android_v1.feature.main.model

data class Comment(
    val content: String,
    val created_date: String,
    val id: Int,
    val replies: List<Reply>,
    val reply_count: Int,
    val writer: WriterX
)