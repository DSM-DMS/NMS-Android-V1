package com.example.nms_android_v1.di

import BASE_URL
import com.example.nms_android_v1.data.login.LoginApi
import com.example.nms_android_v1.data.main.MainApi
import com.example.nms_android_v1.data.mypage.MypageApi
import com.example.nms_android_v1.data.post.PostApi
import com.example.nms_android_v1.data.profile.ProfileApi
import com.example.nms_android_v1.data.register.RegisterApi
import com.example.nms_android_v1.data.star.StarApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

val loginApi : LoginApi by lazy {
    retrofit.create(LoginApi::class.java)
}

val registerApi : RegisterApi by lazy {
    retrofit.create(RegisterApi::class.java)
}

val mainApi : MainApi by lazy {
    retrofit.create(MainApi::class.java)
}

val starApi : StarApi by lazy {
    retrofit.create(StarApi::class.java)
}

val mypageApi : MypageApi by lazy {
    retrofit.create(MypageApi::class.java)
}

val postApi : PostApi by lazy {
    retrofit.create(PostApi::class.java)
}

val profileApi: ProfileApi by lazy{
    retrofit.create(ProfileApi::class.java)
}