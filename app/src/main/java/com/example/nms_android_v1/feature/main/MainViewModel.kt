package com.example.nms_android_v1.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.main.MainRepository
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.PostsResponse

class MainViewModel(
    private val rp: MainRepository
) : ViewModel() {

    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val postsData : MutableLiveData<PostsResponse> = MutableLiveData()

    fun getPosts() {
        rp.getPosts().subscribe { response ->
            if(response.isSuccessful) {
                postsData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}