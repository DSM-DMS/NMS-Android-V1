package com.example.nms_android_v1.feature.main.model

data class Reply(
    val content: String,
    val created_date: String,
    val id: Int,
    val writer: Writer
)