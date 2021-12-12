package com.example.nms_android_v1.data.profile

import ACCESS_TOKEN
import com.example.nms_android_v1.di.profileApi

import com.example.nms_android_v1.feature.profile.dto.ResponseProfileDTO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class ProfileRepository {
    fun getProfile(id: Int) : @NonNull Single<Response<ResponseProfileDTO>> =
        profileApi.getProfile(ACCESS_TOKEN, id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}