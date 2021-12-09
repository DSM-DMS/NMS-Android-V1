package com.example.nms_android_v1.feature.mypage.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.ListpostItemBinding
import com.example.nms_android_v1.databinding.MainItemBinding
import com.example.nms_android_v1.feature.main.adapter.MainAdapter
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import com.example.nms_android_v1.feature.mypage.dto.liked_notices_value
import com.example.nms_android_v1.feature.mypage.model.LikePostData
import com.example.nms_android_v1.feature.post.model.viewmodel.PostViewModel
import com.example.nms_android_v1.feature.post.ui.PostActivity

class LikePostAdapter(
    private val context: Context,
    private val LikePostData: List<liked_notices_value>,
    private val vm: PostViewModel
) : RecyclerView.Adapter<LikePostAdapter.ViewHolder>() {

    private var datas = mutableListOf<LikePostData>()

    private lateinit var binding: ListpostItemBinding

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ListpostItemBinding>(LayoutInflater.from(parent.context),
            R.layout.listpost_item, parent, false)

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.run {
            LikePostData[position].run {
                Glide.with(holder.itemView.context)
                    .load(image)
                    .into(likephoto)

                tvTitle.text = title
                tvWriter.text = writer
                tvCreatedDate.text = created_date

                totalItem.setOnClickListener {
                    val intent = Intent(holder.itemView.context, PostActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("noticeId", id)
                    holder.itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return LikePostData.size
    }
}