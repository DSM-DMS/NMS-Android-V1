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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etRgFirst.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnNext.background = ContextCompat.getDrawable(applicationContext, R.drawable.bg_register_btn_border_on)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        val itemList = listOf("1학년", "2학년", "3학년")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, itemList)
        binding.spinnerGrade.adapter = adapter

        binding.spinnerGrade.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.tvSpinnerGrade.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                binding.tvSpinnerGrade.text = itemList[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        nickName()
    }

    private fun nickName() {
        binding.etRgFirst.visibility = View.VISIBLE
        binding.etRgFirst.hint = "닉네임"

        binding.btnNext.setOnClickListener {
            nickname = binding.etRgFirst.text.toString()

            if(nickname.isNullOrEmpty()) showToast("닉네임을 입력해주세요.")
            else name()
         }

    }

    private fun name() {
        binding.etRgFirst.visibility = View.VISIBLE
        binding.etRgFirst.text = null
        binding.etRgFirst.hint = "이름"

        binding.btnNext.setOnClickListener {
            name = binding.etRgFirst.text.toString()

            if(nickname.isNullOrEmpty()) showToast("이름을 입력해주세요.")
            else numberGrade()
        }
    }

    private fun numberGrade() {
    }

    private fun password() {

    }

    override fun observeEvent() {}
}