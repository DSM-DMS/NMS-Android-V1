package com.example.nms_android_v1.feature.mypage.dto

data class ResponseMyPageDTO(
    val nickname :  String,
    val name : String,
    val gcn : String,
    val email : String,
    val profile_url : String,
    val likedNoticesValue: liked_notices_value
)

data class liked_notices_value (
    val id : String,
    val title : String,
    val writer :  String,
    val department : String,
    val created_date : String,
    val image : String
)