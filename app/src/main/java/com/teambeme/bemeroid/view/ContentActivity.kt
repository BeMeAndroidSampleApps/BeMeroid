package com.teambeme.bemeroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.teambeme.bemeroid.R
import com.teambeme.bemeroid.adapter.ProjectAdapter
import com.teambeme.bemeroid.databinding.ActivityContentBinding
import com.teambeme.bemeroid.model.ProjectData

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        initUI()
        setAdapter()
    }

    private fun initUI() {
        val id = intent.getStringExtra("ID") ?: ""
        binding.txtContentsId.text = "안녕하세요 ${id}님"
    }

    private fun setAdapter() {
        val projectAdapter = ProjectAdapter()
        projectAdapter.replaceList(provideProjectList())
        binding.rvProjectList.adapter = projectAdapter
    }

    private fun provideProjectList() = listOf(
        ProjectData(
            imgProject = R.drawable.ic_kotlin,
            txtProjectTitle = "BeMe",
            txtProjectContents = "비미비미비미업"
        ),
        ProjectData(
            imgProject = R.drawable.ic_kotlin,
            txtProjectTitle = "Ounce",
            txtProjectContents = "온스 고양이 너무 귀여웡"
        ),
        ProjectData(
            imgProject = R.drawable.ic_kotlin,
            txtProjectTitle = "Maru",
            txtProjectContents = "책읽고 싶다 책책책"
        ),
        ProjectData(
            imgProject = R.drawable.ic_kotlin,
            txtProjectTitle = "Wordata",
            txtProjectContents = "단어 외우기 겁나 싫음"
        ),
        ProjectData(
            imgProject = R.drawable.ic_kotlin,
            txtProjectTitle = "CcookCcook",
            txtProjectContents = "나에게 굴욕감을 안겨줬어"
        ),
    )
}