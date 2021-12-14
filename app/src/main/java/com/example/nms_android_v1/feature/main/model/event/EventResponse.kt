package com.example.nms_android_v1.feature.main.model.event


import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("notice_count")
    val noticeCount: Int,
    val notices: List<Notice>
)