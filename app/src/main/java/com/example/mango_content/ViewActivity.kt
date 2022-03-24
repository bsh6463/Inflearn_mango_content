package com.example.mango_content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth

        val webView = findViewById<WebView>(R.id.webView)

        webView.loadUrl(intent.getStringExtra("url").toString())

        val saveBtn = findViewById<TextView>(R.id.saveBtn)
        saveBtn.setOnClickListener {
            // Write a message to the database
            val database = Firebase.database
            val myBookMarkRef = database.getReference("bookmark_ref")

            val url = intent.getStringExtra("url").toString()
            val title = intent.getStringExtra("title").toString()
            val imageUrl = intent.getStringExtra("imageUrl").toString()

            myBookMarkRef
                .child(auth.currentUser!!.uid)
                .setValue(ContentModel(url, imageUrl, title))

            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_LONG).show()

        }


    }
}