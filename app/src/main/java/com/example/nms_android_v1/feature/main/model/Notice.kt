package com.example.nms_android_v1.feature.main.model

data class Notice(
    val comment_count: Int?,
    val comments: List<Comment>?,
    val content: String,
    val created_date: String,
    val images: List<String>?,
    val is_star: Boolean,
    val notice_id: Int,
    val star_count: Int,
    val targets: List<String>?,
    val title: String,
    val updated_date: String,
    val writer: WriterXX
)