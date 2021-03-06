package com.example.nms_android_v1.feature.mypage.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.mypage.MypageRepository
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO

class MyInformationViewModel(
    private val repository: MypageRepository,
) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val MypageData : MutableLiveData<ResponseMyPageDTO> = MutableLiveData()

    fun myInformation() {
        repository.getInformation().subscribe { response ->
            if(response.isSuccessful) {
                MypageData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}