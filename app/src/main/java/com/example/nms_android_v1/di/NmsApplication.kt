package com.example.nms_android_v1.di

import android.app.Application
import com.example.nms_android_v1.di.module.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NmsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NmsApplication)

            modules(loginModule)
        }
    }
}