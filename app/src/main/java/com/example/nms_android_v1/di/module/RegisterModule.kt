package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.data.register.RegisterRepository
import com.example.nms_android_v1.feature.login.viewmodel.LoginViewModel
import com.example.nms_android_v1.feature.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerModule = module {
    factory { RegisterRepository() }
    viewModel { RegisterViewModel(get()) }
}
