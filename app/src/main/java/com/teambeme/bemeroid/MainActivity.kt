package com.teambeme.bemeroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teambeme.bemeroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 클래스의 private 변수로 선언
    // 지연 초기화(선언 당시에는 초기화를 못해)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    // 코틀린에서 상수 저장 컨벤션
    companion object {
        const val ID = "l2hyunwoo"
        const val PASSWORD = "1234qwer"
    }
}