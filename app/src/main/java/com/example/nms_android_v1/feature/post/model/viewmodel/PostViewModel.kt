package com.example.nms_android_v1.feature.post.model.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.post.PostRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import android.content.Intent.getIntent

import android.content.Intent
import com.example.nms_android_v1.feature.post.ui.PostActivity
import kotlin.properties.Delegates

class PostViewModel (
    private val repository: PostRepository
) : ViewModel() {

    private val postActivity = PostActivity()
    private val sp: StarRepository = StarRepository()
    private val toastMessage : MutableLiveData<String> = MutableLiveData()
    private val failed : MutableLiveData<Boolean> = MutableLiveData()
    private val postData : MutableLiveData<ResponsePostDTO> = MutableLiveData()

    fun getPostDetail() {
        val notice_id = postActivity.notice_id

        repository.getPostDetail(notice_id).subscribe { response ->
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

    fun unStar(noticeId: String) {
        sp.star(noticeId).subscribe { response ->
            if(response.isSuccessful) {
                toastMessage.value = "취소 성공"
            } else {
                toastMessage.value = "데이터 통신 실패"
            }
        }
    }
}