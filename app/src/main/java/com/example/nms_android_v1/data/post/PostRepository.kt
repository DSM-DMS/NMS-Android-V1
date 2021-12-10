package com.example.nms_android_v1.data.post

import ACCESS_TOKEN
import com.example.nms_android_v1.di.postApi
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class PostRepository {
    fun getPostDetail(notice_id: Int) : @NonNull Single<Response<ResponsePostDTO>> =
        postApi.getPostDetail(ACCESS_TOKEN, notice_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}