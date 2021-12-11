package com.example.nms_android_v1.feature.login.model

import com.google.gson.annotations.SerializedName

data class SendEmailCertifiedRequest(
    @SerializedName("email") val email: String
)