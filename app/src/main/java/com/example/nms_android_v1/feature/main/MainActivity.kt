package com.example.nms_android_v1.feature.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMainBinding
import com.example.nms_android_v1.feature.main.adapter.MainAdapter
import com.example.nms_android_v1.feature.main.model.Notices
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.main.model.Writer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    val vm: MainViewModel by viewModel()

    val postList = arrayListOf<Notices>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = MainAdapter(applicationContext, postList)

        vm.getPosts()
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
                it.run {
                    showToast("데이터 통신에 실패하였습니다.")
                }
            })
        }
    }
}