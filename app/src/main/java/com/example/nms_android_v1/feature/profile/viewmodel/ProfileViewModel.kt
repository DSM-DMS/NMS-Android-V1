package com.example.nms_android_v1.feature.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.profile.ProfileRepository
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import com.example.nms_android_v1.feature.profile.dto.ResponseProfileDTO
import com.example.nms_android_v1.feature.profile.ui.ProfileActivity

class ProfileViewModel(
    private val repository: ProfileRepository,
) : ViewModel() {

    private val id = ProfileActivity.teacherId
    val profileData : MutableLiveData<ResponseProfileDTO> = MutableLiveData()
    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun getProfile() {
        repository.getProfile(id).subscribe { response ->
            if(response.isSuccessful) {
                profileData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}