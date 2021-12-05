package com.example.nms_android_v1.feature.post.dto


data class ResponsePostDTO(
    val notice_id: Int,
    val title: String,
    val content: String,
    val writer: writer,
    val target: targets,
    val created_date : String,
    val update_date: String,
    val images: images,
    val is_star: Boolean,
    val star_count : Int,
    val comment_count : Int,
    val comments : comments
)

data class writer(
    val name: String,
    val profile_url: String
)

data class targets(
    val target: String
)

data class images(
    val order_seq : Int,
    val image_url : String
)

data class comments(
    val id : Int,
    val writer: writer,
    val content : String,
    val created_date: String,
    val replies: replies
)

data class replies(
    val id: Int,
    val writer: writer,
    val content: String,
    val created_date: String
)