package com.example.nms_android_v1.data.main

import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MainApi {
    // 전체 공지사항 조회
    @GET("notice/all")
    fun getPosts(
        @Header("Authorization") accessToken: String
    ) : Single<Response<PostsResponse>>

    // 공지사항 단일 조회
    @GET("notice")
    fun getTargetPosts(
        @Header("Authorization") accessToken: String,
        @Query("target") target: String
    ) : Single<Response<PostsResponse>>
}