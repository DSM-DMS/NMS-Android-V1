package com.example.nms_android_v1.feature.mypage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nms_android_v1.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMainBinding
import com.example.nms_android_v1.databinding.ActivityMypageBinding
import com.example.nms_android_v1.feature.main.MainViewModel
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.mypage.model.viewmodel.MypageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MypageActivity : BaseActivity<ActivityMypageBinding>(
    R.layout.activity_mypage
) {

    val vm: MypageViewModel by viewModel()

    private lateinit var rv: RecyclerView
    private lateinit var MypageAdpater: LikePostAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        rv.layoutManager = gridLayoutManager
    }

    override fun observeEvent() {
        vm.run {

        }
    }
}