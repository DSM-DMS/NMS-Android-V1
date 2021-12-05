package com.example.nms_android_v1.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeEvent() {
        vm.run {

        }
    }
}