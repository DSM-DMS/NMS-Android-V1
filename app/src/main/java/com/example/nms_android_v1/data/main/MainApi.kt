package com.example.nms_android_v1.data.main

import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface MainApi {
    @GET("notice")
    fun getPosts(
        @Header("Authorization") accessToken: String
    ) : Single<Response<PostsResponse>>
}