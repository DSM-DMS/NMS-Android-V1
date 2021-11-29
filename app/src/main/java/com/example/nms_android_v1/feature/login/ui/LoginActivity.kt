package com.example.nms_android_v1.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityLoginBinding
import com.example.nms_android_v1.feature.login.model.LoginRequest
import com.example.nms_android_v1.feature.login.viewmodel.LoginViewModel
import com.example.nms_android_v1.feature.main.MainActivity
import com.example.nms_android_v1.feature.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(
    R.layout.activity_login
) {

    val vm: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run{
            tvLoginRegister.setOnClickListener {
                startRegister()
            }

            btnLogin.setOnClickListener {
                val ID = etLoginID.text.toString()
                val PW = etLoginPW.text.toString()

                if(ID.isEmpty() || PW.isEmpty()) {
                    showToast("아이디 또는 비밀번호를 입력해주세요.")
                    return@setOnClickListener
                }

                vm.login(LoginRequest(ID, PW))
            }

            var showPw: Boolean = false
            ibSeeAccount.setOnClickListener {
                showPw = !showPw

                etLoginPW.run {
                    if(showPw) {
                        transformationMethod = HideReturnsTransformationMethod.getInstance()
                    } else {
                        transformationMethod = PasswordTransformationMethod.getInstance()
                    }
                }

            }
        }
    }

    private fun startRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@LoginActivity, {
                it.run {
                    showToast("로그인에 성공하셨습니다.")
                    startMain()
                }
            })

            failed.observe(this@LoginActivity, {
                it.run {
                    showToast("로그인에 실패하셨습니다.")
                    startMain()
                }
            })
        }
    }
}