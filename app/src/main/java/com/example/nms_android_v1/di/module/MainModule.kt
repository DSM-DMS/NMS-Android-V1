package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.data.main.MainRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.login.viewmodel.LoginViewModel
import com.example.nms_android_v1.feature.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory { MainRepository() }
    factory { StarRepository() }
    viewModel { MainViewModel(get(), get()) }
}
