package com.example.nms_android_v1.feature.mypage.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.mypage.MypageRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO

class MypageViewModel(
    private val repository: MypageRepository
    private val sp: StarRepository
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

    fun star(noticeId: String) {
        sp.star(noticeId).subscribe { response ->
            if(response.isSuccessful) {
                toastMessage.value = "좋아요 성공"
            } else {
                toastMessage.value = "데이터 통신 실패"
            }
        }
    }

    fun unstar(noticeId: String) {
        sp.star(noticeId).subscribe { response ->
            if(response.isSuccessful) {
                toastMessage.value = "취소 성공"
            } else {
                toastMessage.value = "데이터 통신 실패"
            }
        }
    }
}