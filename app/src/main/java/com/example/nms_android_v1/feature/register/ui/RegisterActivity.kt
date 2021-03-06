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
import kotlin.math.log

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    R.layout.activity_register
) {

    val vm: RegisterViewModel by viewModel()

    var nickname: String ?= null
    var name: String ?= null
    var grade: String ?= null
    var classNum: String ?= null
    var number: String ?= null
    var password: String ?= null
    var email: String ?= null

    var page = 1

    var emailCertified: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movePage(1)
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

    private fun movePage(page: Int) {
        viewGone()
        when(page) {
            1 -> {
                nickName()
                binding.ivBack.setImageResource(R.drawable.ic_cancel)
                binding.ivBack.setOnClickListener {
                    finish()
                }
            }
            2 -> {
                name()
                binding.ivBack.setImageResource(R.drawable.ic_back)
                binding.ivBack.setOnClickListener {
                    movePage(--this.page)
                }
            }
            3 -> numberGrade()
            4 -> password()
            5 -> email()
            6 -> certifiedEmail()
            7 -> success()
            else -> nickName()
        }
    }

    private fun viewGone() {
        binding.run {
            etRgFirst.text = null
            etRgSecond.text = null
            spinnerGrade.visibility = View.GONE
            tvSpinnerGrade.visibility = View.GONE
            spinnerIg.visibility = View.GONE
            etRgSecond.visibility = View.GONE
        }
    }

    private fun nickName() {
        emailCertified = 0;

        setTextWatcher()

        binding.etRgFirst.hint = "?????????"

        binding.btnNext.setOnClickListener {
            nickname = binding.etRgFirst.text.toString()

            if(nickname.isNullOrEmpty()) showToast("???????????? ??????????????????.")
            else movePage(++page)
         }

    }

    private fun name() {
        setTextWatcher()

        binding.etRgFirst.hint = "??????"

        binding.btnNext.setOnClickListener {
            name = binding.etRgFirst.text.toString()

            if(name.isNullOrEmpty()) showToast("????????? ??????????????????.")
            else movePage(++page)
        }
    }

    private fun numberGrade() {
        setTextWatcher()

        binding.etRgFirst.hint = "?????? (ex.1117)"

        val itemList = listOf("1??????", "2??????", "3??????")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, itemList)
        binding.spinnerGrade.adapter = adapter

        binding.spinnerGrade.visibility = View.VISIBLE
        binding.tvSpinnerGrade.visibility = View.VISIBLE
        binding.spinnerIg.visibility = View.VISIBLE

        binding.spinnerGrade.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.tvSpinnerGrade.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                binding.tvSpinnerGrade.text = itemList[p2]

                when(p2) {
                    0 -> grade = "FIRST"
                    1 -> grade = "SECOND"
                    2 -> grade = "THIRD"
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.btnNext.setOnClickListener {
            number = binding.etRgFirst.text.toString()

            classNum = number!!.substring(1, 2)
            number = number!!.substring(2, 4)

            if(number.isNullOrEmpty()) {
                showToast("????????? ??????????????????.")
                return@setOnClickListener
            }
            if(grade.isNullOrEmpty()) {
                showToast("????????? ??????????????????.")
                return@setOnClickListener
            }

            movePage(++page)
        }

    }

    private fun password() {
        setTextWatcher()

        binding.etRgFirst.hint = "????????????"

        binding.etRgSecond.visibility = View.VISIBLE

        binding.btnNext.setOnClickListener {
            password = binding.etRgFirst.text.toString()
            val passwordCheck = binding.etRgSecond.text.toString()
            if(password == passwordCheck) {
                movePage(++page)
            }
        }

    }

    private fun email() {
        binding.etRgFirst.hint = "????????? (?????? ???????????? ??????????????????)"
        binding.btnNext.text = "???????????? ??????"

        binding.btnNext.setOnClickListener {
            email = binding.etRgFirst.text.toString()

            if(email.isNullOrEmpty()) showToast("???????????? ??????????????????.")
            else movePage(++page)
        }
    }

    private fun certifiedEmail() {
        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "???????????? ??????"
        binding.btnNext.text = "??????"
        binding.tvEmail.visibility = View.VISIBLE
        binding.textView4.visibility = View.VISIBLE
        binding.textView5.visibility = View.VISIBLE

        vm.sendEmailCertified(email!!)

        binding.btnNext.setOnClickListener {
            val code = binding.etRgFirst.text.toString()

            if(code.isNullOrEmpty()) {
                showToast("??????????????? ??????????????????!")
            } else {
                vm.checkEmailCertified(email!!, code)
            }
        }

        binding.textView5.setOnClickListener {
            if(emailCertified != 3) {
                showToast("${email}??? ??????????????? ????????????????????????.")
                vm.sendEmailCertified(email!!)
                emailCertified++
            } else {
                showToast("???????????? ????????? ?????? ????????? ?????????????????????.\n?????? ??????????????? ??????????????????!")
            }
        }
    }

    private fun success() {
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
                showToast("??????????????? ???????????? ????????????.")
            })

            errorMessage.observe(this@RegisterActivity, {
                showToast(it)
            })

            success.observe(this@RegisterActivity, {
                it.run {
                    showToast("??????????????? ?????????????????????.")
                    finish()
                }
            })

            failed.observe(this@RegisterActivity, {
                it.run {
                    showToast(it)
                    finish()
                }
            })
        }
    }
}