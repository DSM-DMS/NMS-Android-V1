package com.example.nms_android_v1.feature.profile.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.profile.ProfileRepository

class ProfileViewModel(
    private val repository: ProfileRepository,
) : ViewModel() {
}