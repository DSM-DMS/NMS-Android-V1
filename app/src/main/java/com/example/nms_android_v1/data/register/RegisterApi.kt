package com.example.nms_android_v1.data.register

import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface RegisterApi {
    @GET("join")
    fun register(
        @Body registerRequest: RegisterRequest
    ) : Single<Response<Void>>
}