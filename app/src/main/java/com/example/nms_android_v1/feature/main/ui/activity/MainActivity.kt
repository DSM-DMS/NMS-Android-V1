package com.example.nms_android_v1.feature.main.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMainBinding
import com.example.nms_android_v1.feature.main.adapter.MainAdapter
import com.example.nms_android_v1.feature.main.ui.fragment.BottomDialogFragment
import com.example.nms_android_v1.feature.main.model.BottomDialog.BottomDialogData
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    val vm: MainViewModel by viewModel()

    val postList = arrayListOf<Notices>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        val listType = mutableListOf(
            BottomDialogData("교외"),
            BottomDialogData("교내")
        )

        val listGrade  = mutableListOf(
            BottomDialogData("1학년"),
            BottomDialogData("2학년"),
            BottomDialogData("3학년")
        )

        val bottomDialogFragment = BottomDialogFragment(listType, listGrade, vm)

        binding.textView166.setOnClickListener {
            bottomDialogFragment.show(supportFragmentManager, "Tag")
        }

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = MainAdapter(applicationContext, postList, vm)

//        vm.getPosts()
    }

    private fun setPosts(postsResponse: PostsResponse) {
        for(i: Int in 1..postsResponse.notice_count) {
            postList.add(postsResponse.notices.get(i))
        }
        binding.rvMain.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        vm.run {
            postsData.observe(this@MainActivity, {
                setPosts(it)
            })

            failed.observe(this@MainActivity, {
                showToast(it.toString())
            })

            toastMessage.observe(this@MainActivity, {
                showToast(it.toString())
            })
        }
    }
}