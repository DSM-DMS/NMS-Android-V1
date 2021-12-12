package com.example.nms_android_v1.feature.main.model

data class PostsResponse(
    val notice_count: Int,
    val notices: List<Notice>
)