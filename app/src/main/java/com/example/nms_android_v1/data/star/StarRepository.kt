package com.example.nms_android_v1.data.star

import ACCESS_TOKEN
import com.example.nms_android_v1.di.loginApi
import com.example.nms_android_v1.di.registerApi
import com.example.nms_android_v1.di.starApi
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.login.model.LoginResponse
import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class StarRepository {

    fun star(noticeId: String) : @NonNull Single<Response<Void>> =
        starApi.star(noticeId, ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun unStar(noticeId: String) : @NonNull Single<Response<Void>> =
        starApi.unstar(noticeId, ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}