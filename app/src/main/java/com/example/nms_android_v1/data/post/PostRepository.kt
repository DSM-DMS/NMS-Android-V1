package com.example.nms_android_v1.data.post

import ACCESS_TOKEN
import com.example.nms_android_v1.di.postApi
import com.example.nms_android_v1.feature.main.model.PostsResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class PostRepository {
    fun getPostDetail() : @NonNull Single<Response<PostsResponse>> =
        // notice id 오류 방지를 위해 예시로 넣어둠
        postApi.getPostDetail(ACCESS_TOKEN, notice_id = 123)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}