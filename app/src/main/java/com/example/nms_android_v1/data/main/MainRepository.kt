package com.example.nms_android_v1.data.main

import ACCESS_TOKEN
import com.example.nms_android_v1.di.mainApi
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.main.model.event.EventResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MainRepository {

    fun getPosts() : @NonNull Single<Response<PostsResponse>> =
        mainApi.getPosts(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getTargetPosts(target: String) : @NonNull Single<Response<PostsResponse>> =
        mainApi.getTargetPosts(ACCESS_TOKEN, target)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getEvent() : @NonNull Single<Response<EventResponse>> =
        mainApi.getEvent(ACCESS_TOKEN, "SUBURBS")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}