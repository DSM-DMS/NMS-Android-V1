package com.example.nms_android_v1.feature.login.viewmodel

import accessToken
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.feature.login.model.LoginRequest
import org.koin.core.Koin
import refreshToken

class LoginViewModel(
    private val rp: LoginRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        rp.login(loginRequest).subscribe { response ->
            if(response.isSuccessful) {
                accessToken = response.body()?.accessToken.toString()
                refreshToken = response.body()?.accessToken.toString()
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}