package com.example.nms_android_v1.data.post

import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PostApi {

    // 공지 사항 조회
    @GET("notice/{notice-id}")
    fun getPostDetail(
        @Header("Authorization") access_token: String,
        @Path("notice_id") notice_id : Int
    ) : Single<Response<ResponsePostDTO>>
}