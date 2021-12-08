package com.example.nms_android_v1.feature.main.model

import com.google.gson.annotations.SerializedName

data class PostsResponse (

	@SerializedName("notice_count") val notice_count : Int,
	@SerializedName("notices") val notices : List<Notices>
)