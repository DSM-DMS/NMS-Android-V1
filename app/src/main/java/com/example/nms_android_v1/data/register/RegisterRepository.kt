package com.example.nms_android_v1.data.register

import com.example.nms_android_v1.di.registerApi
import com.example.nms_android_v1.feature.login.model.CheckEmailCertifiedRequest
import com.example.nms_android_v1.feature.login.model.SendEmailCertifiedRequest
import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class RegisterRepository {

    fun register(registerRequest: RegisterRequest) : @NonNull Single<Response<Void>> =
        registerApi.register(registerRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun sendEmailCertified(email: String) : @NonNull Single<Response<Void>> =
        registerApi.sendEmailCertified(SendEmailCertifiedRequest(email))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun checkEmailCertified(email: String, code: String) : @NonNull Single<Response<Void>> =
        registerApi.checkEmailCertified(CheckEmailCertifiedRequest(email, code))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}