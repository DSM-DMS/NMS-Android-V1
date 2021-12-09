package com.example.nms_android_v1.feature.post.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.ChatByChatItemBinding
import com.example.nms_android_v1.databinding.ChatItemBinding
import com.example.nms_android_v1.feature.mypage.model.LikePostData
import com.example.nms_android_v1.feature.post.dto.comments
import com.example.nms_android_v1.feature.post.dto.replies
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import java.nio.file.Files.size

class PostChatByChatAdapter (
    private val context: Context,
    private val replies: List<replies>,
    private val vm: PostViewModel
) :
    RecyclerView.Adapter<PostChatByChatAdapter.ViewHolder>() {

    var datas = mutableListOf<LikePostData>()

    private lateinit var binding: ChatByChatItemBinding

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ChatByChatItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.chat_by_chat_item, parent, false)

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.run {
            replies[position].run {
                tvName.text = writer.name
                tvContent.text = content
                tvTime.text = created_date
            }
        }
    }

    override fun getItemCount(): Int {
        return replies.size
    }
}