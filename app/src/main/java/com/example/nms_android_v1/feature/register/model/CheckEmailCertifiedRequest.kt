package com.example.nms_android_v1.feature.register.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class CheckEmailCertifiedRequest(
    @SerializedName("email") val email: String,
    @SerializedName("code") val code: String,
)
