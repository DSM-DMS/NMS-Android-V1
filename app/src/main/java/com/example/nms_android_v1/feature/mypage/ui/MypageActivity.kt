package com.example.nms_android_v1.feature.mypage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter


class MypageActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var LikePostAdapter: LikePostAdapter
    lateinit var layoutManager: GridLayoutManage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        LikePostAdapter.setLayoutManager(gridLayoutManager)

    }
}