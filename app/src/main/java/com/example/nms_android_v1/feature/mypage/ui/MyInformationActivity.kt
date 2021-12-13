package com.example.nms_android_v1.feature.mypage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMyInformationBinding
import com.example.nms_android_v1.databinding.ActivityProfileBinding
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MyInformationViewModel
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MypageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MyInformationActivity : BaseActivity<ActivityMyInformationBinding>(
    R.layout.activity_my_information
) {

    private val vm: MyInformationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.myInformation()
    }

    private fun setMyInformation(responseMyPageDTO: ResponseMyPageDTO){
        binding.tvName.text = responseMyPageDTO.name
        binding.tvEmail.text = responseMyPageDTO.email
        binding.tvNumber.text = responseMyPageDTO.gcn
        binding.tvNickname.text = responseMyPageDTO.nickname
    }

    override fun observeEvent() {
        vm.run {
            MypageData.observe(this@MyInformationActivity, {
                setMyInformation(it)
            })

            failed.observe(this@MyInformationActivity, {
                showToast(it.toString())
            })

            toastMessage.observe(this@MyInformationActivity, {
                showToast(it.toString())
            })
        }
    }
}