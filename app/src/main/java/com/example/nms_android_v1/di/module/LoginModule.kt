package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.login.LoginRepository

val loginModule = module {
    factory (LoginRepository())
}