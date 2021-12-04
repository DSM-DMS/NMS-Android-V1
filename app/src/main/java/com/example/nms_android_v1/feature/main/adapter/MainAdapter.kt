package com.example.nms_android_v1.feature.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.MainItemBinding
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.Writer

class MainAdapter(
    val context: Context,
    val productData: List<Notices>

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
        var data: Notices = productData.get(position)

        Glide.with(holder.itemView.context)
            .load(data.writer.profile_url)
            .into(binding.ivPostProfile)

    }

    override fun getItemCount(): Int {
        return productData.size
    }
}