package com.example.nms_android_v1.feature.post.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.post.PostRepository
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO

class PostViewModel (
    private val repository: PostRepository
) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val postData : MutableLiveData<ResponsePostDTO> = MutableLiveData()

    fun getPostDetail() {
        repository.getPostDetail().subscribe { response ->
            if(response.isSuccessful) {
                postData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}