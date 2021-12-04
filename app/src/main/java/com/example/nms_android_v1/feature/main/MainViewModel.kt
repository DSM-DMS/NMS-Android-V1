package com.example.nms_android_v1.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.data.main.MainRepository
import com.example.nms_android_v1.data.register.RegisterRepository
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.register.model.RegisterRequest

class MainViewModel(
    private val rp: MainRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun register() {
        rp.getPosts().subscribe { response ->
            if(response.isSuccessful) {
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}