package com.example.nms_android_v1.feature.main.model

import com.google.gson.annotations.SerializedName

data class Notices (

	@SerializedName("notice_id") val notice_id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("content") val content : String,
	@SerializedName("writer") val writer : Writer,
	@SerializedName("targets") val targets : List<Targets>,
	@SerializedName("created_date") val created_date : String,
	@SerializedName("updated_date") val updated_date : String,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("is_star") val is_star : Boolean,
	@SerializedName("star_count") val star_count : Int,
	@SerializedName("comment_count") val comment_count : Int,
	@SerializedName("comments") val comments : List<Comments>
)