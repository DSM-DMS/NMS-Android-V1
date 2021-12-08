 package com.example.nms_android_v1.feature.post.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

 class PostActivity : BaseActivity<ActivityPostBinding>(
     R.layout.activity_post
 ) {

     val vm: PostViewModel by viewModel()

     private lateinit var rv: RecyclerView
     private lateinit var MypageAdpater: LikePostAdapter
     private lateinit var gridLayoutManager: GridLayoutManager

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
     }

     override fun observeEvent() {
         vm.run {

         }
     }
 }