package com.example.nms_android_v1.feature.main.model.event


import com.google.gson.annotations.SerializedName

data class Notice(
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("event_day")
    val eventDay: String,
    val host: String,
    val id: Int,
    val link: String,
    val title: String
)