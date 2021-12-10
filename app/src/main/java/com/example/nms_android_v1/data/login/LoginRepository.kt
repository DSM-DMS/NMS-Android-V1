package com.example.nms_android_v1.data.login

import com.example.nms_android_v1.di.loginApi
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.login.model.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class LoginRepository {

    fun login(loginRequest: LoginRequest) : @NonNull Single<Response<LoginResponse>> =
        loginApi.login(loginRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}