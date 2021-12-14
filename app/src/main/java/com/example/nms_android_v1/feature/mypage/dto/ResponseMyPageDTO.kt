package com.example.nms_android_v1.feature.mypage.dto

import com.google.gson.annotations.SerializedName

data class ResponseMyPageDTO(
    @SerializedName("nickname") val nickname: String,
    @SerializedName("name") val name: String,
    @SerializedName("gcn") val gcn: String,
    @SerializedName("email") val email: String,
    @SerializedName("profile_url") val profile_url: String,
    @SerializedName("started_notice") val started_notice: List<Liked_Notices_Value>
)