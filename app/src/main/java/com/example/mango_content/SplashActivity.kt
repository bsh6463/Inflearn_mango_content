package com.example.mango_content

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth

        //기 로그인 유저인지 확인
        if (auth.currentUser?.uid == null){
            //익명 로그인인데, uid가 없으면 회원가입 필요한 상태
            Handler().postDelayed(
                { startActivity(Intent(this, JoinActivity::class.java))
                    finish()}, 3000)
        }else{
            //회원가입 되어있음.
            Handler().postDelayed(
                { startActivity(Intent(this, MainActivity::class.java))
                    finish()}, 3000)
        }



    }
}