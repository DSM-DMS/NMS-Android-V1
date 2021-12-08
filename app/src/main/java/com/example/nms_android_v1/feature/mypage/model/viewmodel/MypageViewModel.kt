package com.example.nms_android_v1.feature.mypage.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.mypage.MypageRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO

class MypageViewModel(
    private val repository: MypageRepository,
) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val postData : MutableLiveData<ResponseMyPageDTO> = MutableLiveData()

    fun mypage() {
        repository.getMyPage().subscribe { response ->
            if(response.isSuccessful) {
                postData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}