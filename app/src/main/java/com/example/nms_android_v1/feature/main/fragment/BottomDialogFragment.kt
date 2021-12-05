package com.example.nms_android_v1.feature.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nms_android_v1.R
import com.example.nms_android_v1.feature.main.adapter.BottomSheetAdapter
import com.example.nms_android_v1.feature.main.model.BottomDialog.BottomDialogData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.w3c.dom.Text

class BottomDialogFragment(var dataType: MutableList<BottomDialogData>, var dataGrade: MutableList<BottomDialogData>) : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.run {
            findViewById<RecyclerView>(R.id.recyclerView).adapter = BottomSheetAdapter(dataType)
            findViewById<TextView>(R.id.tv_categrio)?.setOnClickListener {
                findViewById<RecyclerView>(R.id.recyclerView).adapter = BottomSheetAdapter(dataType)
                findViewById<TextView>(R.id.tv_categrio).setTextColor(ContextCompat.getColor(context, R.color.black_on))
                findViewById<TextView>(R.id.tv_grade).setTextColor(ContextCompat.getColor(context, R.color.black_off))
            }
            findViewById<TextView>(R.id.tv_grade)?.setOnClickListener {
                findViewById<RecyclerView>(R.id.recyclerView).adapter = BottomSheetAdapter(dataGrade)
                findViewById<TextView>(R.id.tv_categrio).setTextColor(ContextCompat.getColor(context, R.color.black_off))
                findViewById<TextView>(R.id.tv_grade).setTextColor(ContextCompat.getColor(context, R.color.black_on))
            }
        }
    }
}