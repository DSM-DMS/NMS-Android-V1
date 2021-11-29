package com.example.nms_android_v1.data.login

import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.login.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginApi {

    @GET("auth")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Single<Response<LoginResponse>>
}