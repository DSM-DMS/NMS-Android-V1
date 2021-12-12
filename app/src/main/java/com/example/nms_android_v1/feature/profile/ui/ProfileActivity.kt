package com.example.nms_android_v1.feature.profile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.databinding.ActivityProfileBinding
import com.example.nms_android_v1.feature.profile.dto.ResponseProfileDTO
import com.example.nms_android_v1.feature.profile.viewmodel.ProfileViewModel
import kotlin.properties.Delegates
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : BaseActivity<ActivityProfileBinding>(
    R.layout.activity_profile
) {

    val id by Delegates.notNull<Int>()
    private val vm: ProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        intent.getIntExtra("teacherId", id)
    }

    private fun setProfile(responseProfileDTO: ResponseProfileDTO){
        binding.tvName.text = responseProfileDTO.name
        binding.tvEmail.text = responseProfileDTO.email
        binding.tvPhone.text = responseProfileDTO.phone_number
        binding.tvIntroduce.text = responseProfileDTO.introduce
        binding.tvClass.text = responseProfileDTO.department
    }
    override fun observeEvent() {
        vm.run {
            profileData.observe(this@ProfileActivity, {
                setProfile(it)
            })

            failed.observe(this@ProfileActivity, {
                showToast(it.toString())
            })

            toastMessage.observe(this@ProfileActivity, {
                showToast(it.toString())
            })
        }
    }
}