package com.example.nms_android_v1.feature.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.main.MainRepository
import com.example.nms_android_v1.data.star.StarRepository
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.main.model.Targets

class MainViewModel(
    private val mp: MainRepository,
    private val sp: StarRepository
) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val postsData : MutableLiveData<PostsResponse> = MutableLiveData()

    fun getPosts() {
        mp.getPosts().subscribe { response ->
            if(response.isSuccessful) {
                postsData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }

    fun getTargetPosts(target: String) {
        mp.getTargetPosts(target).subscribe { response ->
            if(response.isSuccessful) {
                postsData.value = response.body()
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