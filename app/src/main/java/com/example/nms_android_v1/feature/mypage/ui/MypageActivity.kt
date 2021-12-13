package com.example.nms_android_v1.feature.mypage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.nms_android_v1.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMypageBinding
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.mypage.dto.Liked_Notices_Value
import com.example.nms_android_v1.feature.mypage.dto.ResponseMyPageDTO
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MypageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.System.load


class MypageActivity : BaseActivity<ActivityMypageBinding>(
    R.layout.activity_mypage
) {

    private val vm: MypageViewModel by viewModel()

    private var data = arrayListOf<Liked_Notices_Value>()

    private lateinit var MypageAdpater: LikePostAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.rvMyPage.layoutManager = gridLayoutManager
        binding.rvMyPage.adapter = LikePostAdapter(applicationContext, data)

        vm.myPage()

        binding.profileedit.setOnClickListener {
            intent = Intent(this, MyInformationActivity :: class.java)
            startActivity(intent)
        }
    }

    private fun setMypage(ResponseMyPage: ResponseMyPageDTO) {
        binding.tvName.text = ResponseMyPage.name
        binding.tvEmail.text = ResponseMyPage.email

        Glide.with(applicationContext)
            .load(ResponseMyPage.profile_url)
            .into(binding.ivProfile)
    }

    private fun setData(likeData: List<Liked_Notices_Value>) {
        for(i: Int in 0..likeData.size) {

            data.add(likeData.get(i))

            binding.rvMyPage.adapter?.notifyDataSetChanged()
        }
    }
    override fun observeEvent() {
        vm.run {
            MypageData.observe(this@MypageActivity, {
                setMypage(it)
//                setData(it.started_notice)
            })

            toastMessage.observe(this@MypageActivity, {
                showToast(it.toString())
            })
        }
    }
}