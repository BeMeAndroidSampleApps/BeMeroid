package com.teambeme.bemeroid

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teambeme.bemeroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 클래스의 private 변수로 선언
    // 지연 초기화(선언 당시에는 초기화를 못해)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰바인딩 선언
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 리스너
        // 1. 버튼을 누르면 EditText에 있는 값을 가져온다
        // 2. Toast에 그 값을 띄우게 한다

        // 버튼에 setOnClickListener 내부에서 동작을 정의한다
        binding.btnMainLogin.setOnClickListener {
            // 1. EditText 값 가져오기
            // EditText 접근
            // ID 값 가져와서 저장까지!!
            val id = binding.etMainId.text
            // 2. 토스트 띄우기
            Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
        }
    }

    // 코틀린에서 상수 저장 컨벤션
    companion object {
        const val ID = "l2hyunwoo"
        const val PASSWORD = "1234qwer"
    }
}