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
import com.example.nms_android_v1.feature.main.model.WriterXX
import com.example.nms_android_v1.feature.main.model.event.EventResponse
import com.example.nms_android_v1.feature.main.ui.fragment.BottomDialogFragment
import com.example.nms_android_v1.feature.main.viewmodel.MainViewModel
import com.example.nms_android_v1.feature.mypage.ui.MypageActivity
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

        vm.getPosts()
    }

    private fun setPosts(postsResponse: PostsResponse) {
        binding.rvMain.adapter = mainAdapter

        postList.clear()
        for(i: Int in 0..postsResponse.notice_count-2) {
            postList.add(postsResponse.notices.get(i))
        }
        binding.rvMain.adapter?.notifyDataSetChanged()
    }

    private fun setEvent(eventResponse: EventResponse) {
        binding.rvMain.adapter = mainAdapter

        postList.clear()
        for(i: Int in 0..eventResponse.noticeCount-2) {
            var notice: Notice
            eventResponse.notices.get(i).run {
                notice = Notice(null, null, "\t주최 : ${host} \n \t 일시 : ${createdDate} \n \t 링크 : ${link}",
                    createdDate, null, false, id, 0, null, title, createdDate, WriterXX("event", host, null))
            }
            postList.add(notice)
        }
        binding.rvMain.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {

        vm.run {
            postsData.observe(this@MainActivity, {
                Log.d("test", "observeEvent: 실행 ${it}")
                postList.clear()
                setPosts(it)
            })

            failed.observe(this@MainActivity, {
                showToast(it.toString())
            })

            eventData.observe(this@MainActivity, {
                Log.d("test", "observeEvent: 실행2 ${it}")
                postList.clear()
                setEvent(it)
            })

            toastMessage.observe(this@MainActivity, {
                showToast(it.toString())
            })
        }
    }
}