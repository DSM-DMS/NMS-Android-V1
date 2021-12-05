package com.example.nms_android_v1.feature.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nms_android_v1.R
import com.example.nms_android_v1.databinding.MainItemBinding
import com.example.nms_android_v1.feature.main.MainViewModel
import com.example.nms_android_v1.feature.main.model.BottomDialog.BottomDialogData
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.Writer
import com.example.nms_android_v1.feature.post.PostActivity

class BottomSheetAdapter(
    var data: MutableList<BottomDialogData> = ArrayList()
) : RecyclerView.Adapter<BottomSheetAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = data[position]

        holder.tvMenu?.text = item.menu
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvMenu = itemView?.findViewById<TextView>(R.id.tvMenu)
    }

}