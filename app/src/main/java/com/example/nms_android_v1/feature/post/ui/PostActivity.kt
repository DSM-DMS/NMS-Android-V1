 package com.example.nms_android_v1.feature.post.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import com.example.nms_android_v1.feature.post.model.PostData
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

 class PostActivity : BaseActivity<ActivityPostBinding>(
     R.layout.activity_post
 ) {

     private val vm: PostViewModel by viewModel()

     private val postList = arrayListOf<Notices>()

     private lateinit var rv: RecyclerView
     private lateinit var MypageAdpater: LikePostAdapter
     private lateinit var gridLayoutManager: GridLayoutManager
     private lateinit var PostData: ResponsePostDTO
     var notice_id by Delegates.notNull<Int>()

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         val intent = intent
         intent.getIntExtra("notice_id", notice_id)

         vm.getPostDetail()

         binding.lnLike.setOnClickListener{
             if(PostData.is_star) {
                 vm.unStar(notice_id.toString())
             } else {
                 vm.star(notice_id.toString())
             }
         }
     }

     override fun observeEvent() {
     }
 }