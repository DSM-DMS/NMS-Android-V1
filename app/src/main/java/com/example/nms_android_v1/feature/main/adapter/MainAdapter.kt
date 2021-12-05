package com.example.nms_android_v1.feature.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.MainItemBinding
import com.example.nms_android_v1.feature.main.MainViewModel
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.post.ui.PostActivity

class MainAdapter(
    val context: Context,
    val productData: List<Notices>,
    val vm: MainViewModel

    ) : RecyclerView.Adapter<MainAdapter.Holder>() {

    private lateinit var binding: MainItemBinding

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = DataBindingUtil.inflate<MainItemBinding>(LayoutInflater.from(parent.context),
        R.layout.main_item, parent, false)


        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        binding.run {
            productData.get(position).run {
                Glide.with(holder.itemView.context)
                    .load(writer.profile_url)
                    .into(ivPostProfile)

                tvPostMemberName.text = writer.name
                tvPostDate.text = updated_date
                tvPostTitle.text = title
                tvPostContent.text = content
                tvPostLiked.text = star_count.toString()
                tvPostCommtents.text = "댓글 ${comment_count}"

                clItem.setOnClickListener {
                    val intent = Intent(holder.itemView.context, PostActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("noticeId", notice_id)
                    holder.itemView.context.startActivity(intent)
                }

                lnLike.setOnClickListener {
                    if(is_star) {
                        vm.unstar(notice_id.toString())
                    } else {
                        vm.star(notice_id.toString())
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return productData.size
    }
}