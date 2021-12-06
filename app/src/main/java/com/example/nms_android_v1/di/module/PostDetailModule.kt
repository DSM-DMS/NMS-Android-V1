package com.example.nms_android_v1.di.module

import com.example.nms_android_v1.data.post.PostRepository
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postModule = module {
    factory { PostRepository() }
    viewModel { PostViewModel(get()) }
}