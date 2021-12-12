package com.example.nms_android_v1.feature.post.dto


data class ResponsePostDTO(
    val notice_id: Int,
    val title: String,
    val content: String,
    val writer: writer,
    val created_date : String,
    val updated_date: String,
    val star_count : Int,
    val comment_count : Int,
    val comments : List<comments>
)






