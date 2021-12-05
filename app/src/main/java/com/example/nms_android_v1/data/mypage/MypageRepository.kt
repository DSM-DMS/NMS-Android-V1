package com.example.nms_android_v1.data.mypage

import ACCESS_TOKEN
import com.example.nms_android_v1.di.mypageApi
import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MypageRepository {
    fun getPosts() : @NonNull Single<Response<PostsResponse>> =
        mypageApi.getPosts(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}