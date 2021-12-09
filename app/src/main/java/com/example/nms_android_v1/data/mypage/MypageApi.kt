package com.example.nms_android_v1.data.mypage

import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MypageApi {
    @GET("student")
    fun getMypage(
        @Header("Authorization") access_token: String
    ) : Single<Response<ResponseMyPageDTO>>
}