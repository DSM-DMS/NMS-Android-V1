package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.main.MainRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single { MainRepository() }
    single { StarRepository() }
    viewModel { MainViewModel(get(), get()) }
}
