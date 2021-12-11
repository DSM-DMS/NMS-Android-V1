package com.example.nms_android_v1.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.data.login.LoginRepository
import com.example.nms_android_v1.data.register.RegisterRepository
import com.example.nms_android_v1.di.registerApi
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class RegisterViewModel(
    private val rp: RegisterRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()
    val checkSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val checkFailed : MutableLiveData<Boolean> = MutableLiveData()

    fun register(nickname: String, name: String, grade: String, class_num: String, number: String, password: String, email: String) {
        val registerRequest = RegisterRequest(nickname, name, grade, class_num, number, password, email)
        rp.register(registerRequest).subscribe { response ->
            if(response.isSuccessful) {
                success.value = true
            } else {
                failed.value = true
            }
        }
    }

    fun sendEmailCertified(email: String) {
        rp.sendEmailCertified(email).subscribe { response ->
            if(response.isSuccessful) {
            } else {
                errorMessage.value = "서버와의 통신에 실패하였습니다.\n다시 시도해주세요!"
            }
        }
    }

    fun checkEmailCertified(email: String, code: String) {
        rp.checkEmailCertified(email, code).subscribe { response ->
            if(response.isSuccessful) {
                checkSuccess.value = true
            } else {
                checkFailed.value = true
            }
        }
    }
}