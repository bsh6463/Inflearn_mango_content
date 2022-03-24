package com.example.mango_content

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍1")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍2")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍3")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
        "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
                "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페2")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
                "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페3")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍1")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍2")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/gL8RksQTNk",
                "https://mp-seoul-image-production-s3.mangoplate.com/10679/26737_1548857406487_48915?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "보니스피자펍3")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
                "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
                "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페2")
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/zEBLPydf_aV6",
                "https://mp-seoul-image-production-s3.mangoplate.com/2172449_1643612058784557.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "띠앗카페3")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RvAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter

        rvAdapter.itemClick = object: RvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].ImageUrl)
                startActivity(intent)

            }

        }

        recyclerView.layoutManager =  GridLayoutManager(this, 2)

    }
}