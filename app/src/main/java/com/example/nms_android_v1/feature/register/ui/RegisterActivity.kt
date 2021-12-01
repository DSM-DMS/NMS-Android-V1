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
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    R.layout.activity_register
) {

    val vm: RegisterViewModel by viewModel()

    var nickname: String ?= null
    var name: String ?= null
    var number: String ?= null
    var grade: String ?= null
    var password: String ?= null

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
            if(password == binding.etRgSecond.text.toString()) {
                success()
            }
        }

    }

    private fun success() {
        showToast("완료")
    }


    override fun observeEvent() {}
}