package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.mypage.MypageRepository
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MypageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myPageModule = module {
    single { MypageRepository() }
    viewModel { MypageViewModel(get()) }
}