package com.example.nms_android_v1.feature.register.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("department") val department: String,
    @SerializedName("email") val email: String
)
