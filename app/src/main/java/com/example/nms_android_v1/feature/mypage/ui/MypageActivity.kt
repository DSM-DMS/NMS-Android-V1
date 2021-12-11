package com.example.nms_android_v1.feature.mypage.ui

import android.os.Bundle
import com.example.nms_android_v1.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMypageBinding
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MypageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MypageActivity : BaseActivity<ActivityMypageBinding>(
    R.layout.activity_mypage
) {

    private val vm: MypageViewModel by viewModel()

    private lateinit var rv: RecyclerView
    private lateinit var MypageAdpater: LikePostAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        rv.layoutManager = gridLayoutManager
    }

    private fun setMypage(ResponseMyPage: ResponseMyPageDTO) {
        binding.tvName.text = ResponseMyPage.name
        binding.tvEmail.text = ResponseMyPage.email
    }

    override fun observeEvent() {
        vm.run {
            MypageData.observe(this@MypageActivity, {
                setMypage(it)
            })

            failed.observe(this@MypageActivity, {
                showToast(it.toString())
            })

            toastMessage.observe(this@MypageActivity, {
                showToast(it.toString())
            })
        }
    }
}