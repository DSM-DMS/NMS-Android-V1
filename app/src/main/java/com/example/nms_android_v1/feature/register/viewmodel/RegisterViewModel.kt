package com.example.nms_android_v1.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.data.register.RegisterRepository
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.register.model.RegisterRequest

class RegisterViewModel(
    private val rp: RegisterRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun register(registerRequest: RegisterRequest) {
        rp.register(registerRequest).subscribe { response ->
            if(response.isSuccessful) {
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}