package com.example.nms_android_v1.feature.profile.dto

data class ResponseProfileDTO(
    val name: String,
    val email: String,
    val department: String,
    val phone_number: String,
    val introduce: String,
    val profile_url: String
)