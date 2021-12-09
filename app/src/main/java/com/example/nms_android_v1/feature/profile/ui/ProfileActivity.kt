package com.example.nms_android_v1.feature.profile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding>(
    R.layout.activity_profile
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeEvent() {
    }
}