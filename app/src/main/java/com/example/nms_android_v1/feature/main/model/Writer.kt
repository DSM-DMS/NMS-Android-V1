package com.example.nms_android_v1.feature.main.model

import com.google.gson.annotations.SerializedName

data class Writer (
	@SerializedName("name") val name : String,
	@SerializedName("profile_url") val profile_url : String
)