package com.example.nms_android_v1.data.mypage

import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MypageApi {
    @GET("student")
    fun getPosts(
        @Header("access_token") access_token: String
    ) : Single<Response<PostsResponse>>
}