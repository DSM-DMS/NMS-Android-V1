package com.example.nms_android_v1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.model.LikePostData

class LikePostAdapter(private val context: Context?) :
    RecyclerView.Adapter<LikePostAdapter.ViewHolder>() {

    var datas = mutableListOf<LikePostData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikePostAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listpost_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LikePostAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = datas.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}