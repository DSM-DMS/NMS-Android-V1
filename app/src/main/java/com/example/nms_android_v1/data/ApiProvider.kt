package com.example.nms_android_v1.di

import BASE_URL
import com.example.nms_android_v1.data.login.LoginApi
import com.example.nms_android_v1.data.register.RegisterApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

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