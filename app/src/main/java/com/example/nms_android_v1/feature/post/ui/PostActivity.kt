 package com.example.nms_android_v1.feature.post.ui

import android.content.Intent
import android.os.Bundle
import android.view.KeyCharacterMap.load
import android.view.PointerIcon.load
import androidx.core.view.PointerIconCompat.load
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import com.example.nms_android_v1.feature.post.dto.writer
import com.example.nms_android_v1.feature.post.model.PostData
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.System.load
import java.util.ServiceLoader.load
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

     private fun setPostDetail(responsePostDTO: ResponsePostDTO){
         binding.tvTitle.text = responsePostDTO.title
         binding.tvContent.text = responsePostDTO.content
         binding.tvWriter.text = responsePostDTO.writer.name
         binding.tvTarget.text = responsePostDTO.target.target
         binding.tvPostDate.text = responsePostDTO.created_date
         binding.tvCommentCount.text = responsePostDTO.comment_count.toString()
         binding.tvStarCount.text = responsePostDTO.star_count.toString()
     }
     override fun observeEvent() {
         vm.run {
             postDetailData.observe(this@PostActivity, {
                 setPostDetail(it)
             })

             failed.observe(this@PostActivity, {
                 showToast(it.toString())
             })

             toastMessage.observe(this@PostActivity, {
                 showToast(it.toString())
             })
         }
     }
 }