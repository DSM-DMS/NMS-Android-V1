package com.example.nms_android_v1.data.register

import com.example.nms_android_v1.feature.register.model.CheckEmailCertifiedRequest
import com.example.nms_android_v1.feature.register.model.SendEmailCertifiedRequest
import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface RegisterApi {

    // register
    @POST("student")
    fun register(
        @Body registerRequest: RegisterRequest
    ) : Single<Response<Void>>

    // 회원가입 인증 번호 발송
    @POST("email")
    fun sendEmailCertified(
        @Body SendEmailCertifiedRequest: SendEmailCertifiedRequest
    ) : Single<Response<Void>>

    // 인증 번호 확인
    @PUT("email")
    fun checkEmailCertified(
        @Body checkEmailCertifiedRequest: CheckEmailCertifiedRequest
    ) : Single<Response<Void>>
}