package com.example.nms_android_v1.data.star

import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface StarApi {
    @POST("star")
    fun star(
        @Header("Authorization") accessToken: String,
        @Query("notice-id") noticeId: String
    ) : Single<Response<Void>>

    @DELETE("star")
    fun unstar(
        @Header("Authorization") accessToken: String,
        @Query("notice-id") noticeId: String
    ) : Single<Response<Void>>
}