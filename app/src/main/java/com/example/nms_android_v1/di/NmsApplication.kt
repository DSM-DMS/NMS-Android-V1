package com.example.nms_android_v1.di

import android.app.Application
import com.example.nms_android_v1.di.module.loginModule
import com.example.nms_android_v1.di.module.mainModule
import com.example.nms_android_v1.di.module.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NmsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NmsApplication)

            modules(
                listOf(
                    loginModule,
                    registerModule,
                    mainModule
                )
            )
        }
    }
}