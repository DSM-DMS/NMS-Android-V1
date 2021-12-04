package com.example.nms_android_v1.feature.login.viewmodel

import ACCESS_TOKEN
import REFRESH_TOKEN
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.feature.login.model.LoginRequest
import org.koin.core.Koin

class LoginViewModel(
    private val rp: LoginRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        rp.login(loginRequest).subscribe { response ->
            if(response.isSuccessful) {
                ACCESS_TOKEN = response.body()?.accessToken.toString()
                REFRESH_TOKEN = response.body()?.refreshToken.toString()
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}