package com.example.nms_android_v1.feature.post.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.post.PostRepository

class PostViewModel (
    private val repository: PostRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun getPostDetail() {
        repository.getPostDetail().subscribe { response ->
            if(response.isSuccessful) {
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}