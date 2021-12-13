 package com.example.nms_android_v1.feature.post.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityPostBinding
import com.example.nms_android_v1.databinding.ChatItemBinding
import com.example.nms_android_v1.feature.mypage.adapter.LikePostAdapter
import com.example.nms_android_v1.feature.post.dto.ResponsePostDTO
import com.example.nms_android_v1.feature.post.dto.comments
import com.example.nms_android_v1.feature.post.dto.replies
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import com.example.nms_android_v1.feature.profile.ui.ProfileActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

 class PostActivity : BaseActivity<ActivityPostBinding>(
     R.layout.activity_post
 ) {

     private val vm: PostViewModel by viewModel()

     private val postList = arrayListOf<comments>()

     private val postLists = arrayListOf<replies>()
     private lateinit var rv: RecyclerView
     private lateinit var MypageAdpater: LikePostAdapter
     private lateinit var PostData: ResponsePostDTO

     private lateinit var binding2: ChatItemBinding

     private var liked = 0
     companion object {
         var noticeId: Int = 0
     }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         noticeId = intent.getIntExtra("noticeId", noticeId)

         vm.getPostDetail()

//         binding.lnLike.setOnClickListener{
//             if(PostData.is_star) {
//                 vm.unStar(noticeId.toString())
//             } else {
//                 vm.star(noticeId.toString())
//             }
//         }

         binding.ivImage.setOnClickListener{
             val intent2 = Intent(this, ProfileActivity::class.java)
             startActivity(intent2)
         }
     }

     private fun setChat(responsePostDTO: ResponsePostDTO){
         for(i: Int in 1..responsePostDTO.comment_count) {
             postList.add(responsePostDTO.comments[i])
             Log.d("error", "3")
         }
         binding.rv.adapter?.notifyDataSetChanged()
     }

//     private fun setChatByChat(comments: comments){
//         for(j: Int in 1..comments.reply_count) {
//             postLists.add(comments.replies[j])
//         }
//         binding2.rv2.adapter?.notifyDataSetChanged()
//     }


     private fun setPostDetail(responsePostDTO: ResponsePostDTO){
         Log.d("error", "2")
         binding.tvTitle.text = responsePostDTO.title
         binding.tvContent.text = responsePostDTO.content
         binding.tvWriter.text = responsePostDTO.writer.name
         binding.tvPostDate.text = responsePostDTO.created_date
         binding.tvCommentCount.text = responsePostDTO.comment_count.toString()
         binding.tvStarCount.text = responsePostDTO.star_count.toString()
         binding.tvTitle2.text = responsePostDTO.title
         Glide.with(applicationContext)
             .load(responsePostDTO.writer.profile_url)
             .into(binding.ivImage)
     }

     fun setLikeOn() {
         binding.ivGood.setImageResource(R.drawable.ic_like_full)
         binding.tvStarCount.setText("회원님 외 ${liked}명")
     }

     fun setLikeOff() {
         binding.ivGood.setImageResource(R.drawable.ic_like_empty)
         binding.tvStarCount.setText(liked.toString())
     }

     override fun observeEvent() {
         vm.run {
             Log.d("error","10")
                 postDetailData.observe(this@PostActivity, {
                 setPostDetail(it)
                     setChat(it)
                 Log.d("error", "1")
             })

             postChatData.observe(this@PostActivity){
//                 setChatByChat(it)
             }

             toastMessage.observe(this@PostActivity, {
                 showToast(it.toString())

                 if(it == "좋아요 성공") {
                     setLikeOn()
                 }
                 if(it == "취소 성공") {
                     setLikeOff()
                 }
             })
         }
     }
 }