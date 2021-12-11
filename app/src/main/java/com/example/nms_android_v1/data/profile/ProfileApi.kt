package com.example.nms_android_v1.data.profile

import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import com.example.nms_android_v1.feature.profile.dto.ResponseProfileDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileApi {
    // 프로필 조회
    @GET("teacher/{teacher-id}")
    fun getProfile(
        @Header("Authorization") access_token: String,
        @Query("teacher-id") id: Int
    ): Single<Response<ResponseProfileDTO>>
}