package com.example.mango_content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val contentModels = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RvAdapter(this, contentModels)
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager =  GridLayoutManager(this, 2)

        val database = Firebase.database
        val myBookMarkRef = database.getReference("bookmark_ref")

        myBookMarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                  for (dataModel in snapshot.children){
                      Log.d("Datamodel", dataModel.toString())
                      val eachModel = dataModel.getValue(ContentModel::class.java)
                      contentModels.add(eachModel!!)
                  }
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark", "dbError")
                }

            })
    }
}