package com.example.nms_android_v1.feature.register.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityRegisterBinding
import com.example.nms_android_v1.feature.register.viewmodel.RegisterViewModel
import io.reactivex.rxjava3.annotations.NonNull
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    R.layout.activity_register
) {

    val vm: RegisterViewModel by viewModel()

    var nickname: String ?= null
    var name: String ?= null
    var grade: String ?= null
    var number: String ?= null
    var password: String ?= null
    var email: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nickName()
    }

    private fun setTextWatcher() {
        binding.etRgFirst.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnNext.background = ContextCompat.getDrawable(applicationContext, R.drawable.bg_register_btn_border_off)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnNext.background = ContextCompat.getDrawable(applicationContext, R.drawable.bg_register_btn_border_on)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun nickName() {
        setTextWatcher()

        binding.etRgFirst.visibility = View.VISIBLE
        binding.etRgFirst.hint = "닉네임"

        binding.btnNext.setOnClickListener {
            nickname = binding.etRgFirst.text.toString()

            if(nickname.isNullOrEmpty()) showToast("닉네임을 입력해주세요.")
            else name()
         }

    }

    private fun name() {
        setTextWatcher()

        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "이름"

        binding.btnNext.setOnClickListener {
            name = binding.etRgFirst.text.toString()

            if(name.isNullOrEmpty()) showToast("이름을 입력해주세요.")
            else numberGrade()
        }
    }

    private fun numberGrade() {
        setTextWatcher()

        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "학번 (ex.1117)"

        val itemList = listOf("1학년", "2학년", "3학년")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, itemList)
        binding.spinnerGrade.adapter = adapter

        binding.spinnerGrade.visibility = View.VISIBLE
        binding.tvSpinnerGrade.visibility = View.VISIBLE
        binding.spinnerIg.visibility = View.VISIBLE

        binding.spinnerGrade.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.tvSpinnerGrade.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                binding.tvSpinnerGrade.text = itemList[p2]

                grade = p2.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.btnNext.setOnClickListener {
            number = binding.etRgFirst.text.toString()

            if(number.isNullOrEmpty()) {
                showToast("학번을 입력해주세요.")
                return@setOnClickListener
            }
            if(grade.isNullOrEmpty()) {
                showToast("학년을 선택해주세요.")
                return@setOnClickListener
            }

            password()
        }

    }

    private fun password() {
        setTextWatcher()

        binding.spinnerGrade.visibility = View.GONE
        binding.tvSpinnerGrade.visibility = View.GONE
        binding.spinnerIg.visibility = View.GONE

        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "비밀번호"

        binding.etRgSecond.visibility = View.VISIBLE
        binding.etRgSecond.text = null

        binding.btnNext.setOnClickListener {
            password = binding.etRgFirst.text.toString()
            val passwordCheck = binding.etRgSecond.text.toString()
            if(password == passwordCheck) {
                email()
            }
        }

    }

    private fun email() {
        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "이메일 (학교 이메일을 입력해주세요)"
        binding.btnNext.text = "인증번호 요청"
        binding.etRgSecond.visibility = View.GONE

        binding.btnNext.setOnClickListener {
            email = binding.etRgFirst.text.toString()

            if(email.isNullOrEmpty()) showToast("이메일을 입력해주세요.")
            else certifiedEmail()
        }

    }

    private fun certifiedEmail() {
        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "인증번호 입력"
        binding.btnNext.text = "인증"
        binding.tvEmail.visibility = View.VISIBLE
        binding.textView4.visibility = View.VISIBLE
        binding.textView5.visibility = View.VISIBLE

        vm.sendEmailCertified(email!!)

        binding.btnNext.setOnClickListener {
            val code = binding.etRgFirst.text.toString()

            if(code.isNullOrEmpty()) {
                showToast("인증번호를 입력해주세요!")
            } else {
                vm.checkEmailCertified(email!!, code)
            }
        }
    }

    private fun success() {
        val classNum = grade?.substring(1, 1)
        vm.register(nickname!!, name!!, grade!!, classNum!!, number!!, password!!, email!!)
    }


    override fun observeEvent() {
        vm.run {
            checkSuccess.observe(this@RegisterActivity, {
                it.run {
                    success()
                }
            })

            checkFailed.observe(this@RegisterActivity, {
                showToast("인증번호가 일치하지 않습니다.")
            })

            errorMessage.observe(this@RegisterActivity, {
                showToast(it)
            })

            success.observe(this@RegisterActivity, {
                it.run {
                    showToast("회원가입에 성공하셨습니다.")
                    finish()
                }
            })

            failed.observe(this@RegisterActivity, {
                it.run {
                    showToast("회원가입에 실패하셨습니다.\n다시 시도해주세요!")
                    finish()
                }
            })
        }
    }
}