package com.example.nms_android_v1.feature.register.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityRegisterBinding
import com.example.nms_android_v1.feature.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    R.layout.activity_register
) {

    val vm: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnNext.background = ContextCompat.getDrawable(applicationContext, R.drawable.bg_register_btn_border_on)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    override fun observeEvent() {}
}