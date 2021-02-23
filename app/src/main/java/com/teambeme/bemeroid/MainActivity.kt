package com.teambeme.bemeroid

import android.content.Intent
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

        // 로그인 제한조건
        // ID/Password에 적힌 값들이
        // 모두 밑에 있는 상수하고 같아야하지 않겠나
        // 1. 로그인 버튼을 눌렀을 때
        // 2. 적혀져있는 id, pw가 밑에있는 상수와 같아야한다
        // 같으면 로그인 성공 아니면 로그인 실패

        // 1 성공
        binding.btnMainLogin.setOnClickListener {
            if(isLoginEnabled()) onLoginSuccess()
            else onLoginFailure()
        }
    }

    private fun isLoginEnabled() = binding.etMainId.text.toString() == ID &&
            binding.etMainPassword.text.toString() == PASSWORD

    private fun onLoginSuccess() {
        val intent = Intent(this, ContentActivity::class.java)
        intent.putExtra("ID", binding.etMainId.text.toString())
        Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    private fun onLoginFailure() {
        Toast.makeText(this, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
    }

    // 코틀린에서 상수 저장 컨벤션
    companion object {
        const val ID = "l2hyunwoo"
        const val PASSWORD = "1234qwer"
    }
}