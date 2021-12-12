package com.example.nms_android_v1.feature.main.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.R
import com.example.nms_android_v1.base.BaseActivity
import com.example.nms_android_v1.databinding.ActivityMainBinding
import com.example.nms_android_v1.feature.main.adapter.MainAdapter
import com.example.nms_android_v1.feature.main.model.BottomDialog.BottomDialogData
import com.example.nms_android_v1.feature.main.model.Notice
import com.example.nms_android_v1.feature.main.model.PostsResponse
import com.example.nms_android_v1.feature.main.ui.fragment.BottomDialogFragment
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import com.example.nms_android_v1.feature.mypage.ui.MypageActivity
import com.example.nms_android_v1.feature.post.ui.PostActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException
import java.net.SocketException

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    val vm: MainViewModel by viewModel()

    val postList = arrayListOf<Notice>()

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.imageButton.setOnClickListener {
            startActivity(Intent(this, MypageActivity::class.java))
        }
        
        RxJavaPlugins.setErrorHandler { e ->
            var error = e
            if (error is UndeliverableException) {
                error = e.cause
            }
            if (error is IOException || error is SocketException) {
                return@setErrorHandler
            }
            if (error is InterruptedException) {
                return@setErrorHandler
            }
            if (error is NullPointerException || error is IllegalArgumentException) {
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            if (error is IllegalStateException) {
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            Log.w("Undeliverable exception received, not sure what to do", error)
        }

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
        binding.stextView3.setOnClickListener {
            bottomDialogFragment.show(supportFragmentManager, "Tag")
        }

        mainAdapter = MainAdapter(applicationContext, postList, vm)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = mainAdapter

        vm.getPosts()
    }

    private fun setPosts(postsResponse: PostsResponse) {
        postList.clear()
        for(i: Int in 0..postsResponse.notice_count-1) {
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

                if(it == "좋아요 성공") {
                    mainAdapter.setLikeOn()
                }
                if(it == "취소 성공") {
                    mainAdapter.setLikeOff()
                }
            })
        }
    }
}