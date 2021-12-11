package com.example.nms_android_v1.feature.main.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.MainItemBinding
import com.example.nms_android_v1.feature.main.model.Notice
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import com.example.nms_android_v1.feature.post.ui.PostActivity

class MainAdapter(
    val context: Context,
    val productData: List<Notice>,
    val vm: MainViewModel
    ) : RecyclerView.Adapter<MainAdapter.Holder>() {

    private lateinit var binding: MainItemBinding
    var liked = 0

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = DataBindingUtil.inflate<MainItemBinding>(LayoutInflater.from(parent.context),
        R.layout.main_item, parent, false)


        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Log.d("Main", "onBindViewHolder: ${productData.get(position)}")
        binding.run {
            productData.get(position).run {
                if(!(writer.profile_url.isNullOrEmpty())) {
                    Glide.with(holder.itemView.context)
                        .load(writer.profile_url)
                        .into(ivPostProfile)
                }
                tvPostMemberName.text = writer.name
                tvPostDate.text = updated_date
                tvPostTitle.text = title
                tvPostContent.text = content
                liked = star_count
                tvPostLiked.text = star_count.toString()
                tvPostCommtents.text = "댓글 ${comment_count}"

                clItem.setOnClickListener {
                    var intent = Intent(holder.itemView.context, PostActivity::class.java)
                    intent.putExtra("noticeId", notice_id)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    ContextCompat.startActivity(holder.itemView.context, intent, null)
                }

                lnLike.setOnClickListener {
                    vm.star(notice_id.toString())
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return productData.size
    }

    fun setLikeOn() {
        binding.ivItemHeart.setImageResource(R.drawable.ic_like_full)
        binding.tvPostLiked.setText("회원님 외 ${liked}명")
    }

    fun setLikeOff() {
        binding.ivItemHeart.setImageResource(R.drawable.ic_like_empty)
        binding.tvPostLiked.setText(liked.toString())
    }
}