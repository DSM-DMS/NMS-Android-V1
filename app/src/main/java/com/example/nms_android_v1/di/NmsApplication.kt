package com.example.nms_android_v1.di

import android.app.Application

class NmsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

        }
    }
}