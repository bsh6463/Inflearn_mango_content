package com.example.mango_content

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RvAdapter(val context:Context, val List: MutableList<ContentModel> ): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    //viewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        //view 생성
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null


    //holder와 data bind
    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {

        //클릭되었으면?
        if (itemClick != null){
            holder?.itemView.setOnClickListener {
                v -> itemClick!!.onClick(v, position)
            }
        }

        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        fun bindItems(item: ContentModel){
            val rv_img = itemView.findViewById<ImageView>(R.id.rv_image_area)
            val rv_text = itemView.findViewById<TextView>(R.id.rv_text_area)

            rv_text.text = item.titleText

            //mainactivity context작동하겠다?
            //Glide 라이브러리를 통해 웹에서 이미지를 가져와 imageView에 추가 가능
            Glide.with(context).load(item.ImageUrl).into(rv_img)
        }

    }
}