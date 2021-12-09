package com.example.nms_android_v1.feature.post.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.ChatItemBinding
import com.example.nms_android_v1.databinding.ListpostItemBinding
import com.example.nms_android_v1.feature.mypage.model.LikePostData
import com.example.nms_android_v1.feature.post.dto.comments
import com.example.nms_android_v1.feature.post.dto.writer
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import com.example.nms_android_v1.feature.post.ui.PostActivity

class PostChatAdapter (
    private val context: Context,
    private val comments: List<comments>,
    private val vm: PostViewModel
) :
    RecyclerView.Adapter<PostChatAdapter.ViewHolder>() {

    var datas = mutableListOf<LikePostData>()

    private lateinit var binding: ChatItemBinding

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ChatItemBinding>(LayoutInflater.from(parent.context),
            R.layout.chat_item, parent, false)

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.run {
            comments.get(position).run {
                tvWriter.text = writer.name
                tvContent.text = content
                tvCreatedDate.text = created_date
            }
        }
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}