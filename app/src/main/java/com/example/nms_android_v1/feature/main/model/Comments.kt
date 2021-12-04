package com.example.nms_android_v1.feature.main.model

import com.google.gson.annotations.SerializedName

data class Comments (

	@SerializedName("id") val id : Int,
	@SerializedName("writer") val writer : Writer,
	@SerializedName("content") val content : String,
	@SerializedName("created_date") val created_date : String,
	@SerializedName("replies") val replies : List<Replies>
)