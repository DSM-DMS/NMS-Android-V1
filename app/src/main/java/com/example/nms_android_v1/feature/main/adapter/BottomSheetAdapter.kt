package com.example.nms_android_v1.feature.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.feature.main.model.BottomDialog.BottomDialogData
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel

class BottomSheetAdapter(
    var data: MutableList<BottomDialogData> = ArrayList(),
    var vm: MainViewModel
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

        holder.tvMenu?.setOnClickListener {
            when(item.menu) {
                "교내" -> vm.getTargetPosts("SCHOOL")
                "교외" -> vm.getTargetPosts("SUBARBS")
                "1학년" -> vm.getTargetPosts("GRADE_FIRST")
                "2학년" -> vm.getTargetPosts("GRADE_SECOND")
                "3학년" -> vm.getTargetPosts("GRADE_THIRD")
                else -> vm.getPosts()
            }
        }
        
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvMenu = itemView?.findViewById<TextView>(R.id.tvMenu)
    }

}