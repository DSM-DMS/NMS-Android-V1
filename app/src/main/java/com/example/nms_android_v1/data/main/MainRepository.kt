package com.example.nms_android_v1.data.main

import REFRESH_TOKEN
import com.example.nms_android_v1.di.mainApi
import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MainRepository {

    fun getPosts() : @NonNull Single<Response<PostsResponse>> =
        mainApi.getPosts(REFRESH_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


}