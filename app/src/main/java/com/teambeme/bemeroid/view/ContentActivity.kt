package com.teambeme.bemeroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.teambeme.bemeroid.R
import com.teambeme.bemeroid.adapter.ProjectAdapter
import com.teambeme.bemeroid.data.singleton.RetrofitObject
import com.teambeme.bemeroid.databinding.ActivityContentBinding
import com.teambeme.bemeroid.model.ProjectData
import com.teambeme.bemeroid.model.ResponsePeople
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        getPeopleFromServer()
    }

    private fun initUI() {
        val id = intent.getStringExtra("ID") ?: ""
        binding.txtContentsId.text = "안녕하세요 ${id}님"
    }

    private fun setAdapter(people: ResponsePeople) {
        val projectAdapter = ProjectAdapter()
        projectAdapter.replaceList(people.people)
        binding.rvProjectList.adapter = projectAdapter
    }

    private fun getPeopleFromServer() {
        RetrofitObject.peopleInstance
            .getPeople(2)
            .enqueue(object : Callback<ResponsePeople> {
                override fun onResponse(
                    call: Call<ResponsePeople>,
                    response: Response<ResponsePeople>
                ) {
                    setAdapter(response.body()!!)
                }
                override fun onFailure(call: Call<ResponsePeople>, t: Throwable) {
                    Log.d("TAG", t.stackTraceToString())
                }
            })
    }

}