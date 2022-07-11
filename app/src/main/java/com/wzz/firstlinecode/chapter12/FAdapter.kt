package com.wzz.firstlinecode.chapter12

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter04.Fruit

/**
 * @ClassName FAdapter
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/7 14:06
 * @Version 1.0
 */
class FAdapter(val content:Context , val fList:List<Fruit>) : RecyclerView.Adapter<FAdapter.ViewHolder>(){

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val fName = view.findViewById<TextView>(R.id.fruitName)
        val fImage = view.findViewById<ImageView>(R.id.fruitImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(content).inflate(R.layout.fruit_item,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fList[position].let {
            holder.fName.text = it.name
            holder.fImage.setImageResource(it.imageId)
            holder.itemView.setOnClickListener {
                val intent = Intent(content,FruitActivity::class.java).apply {
                    putExtra(FruitActivity.F_NAME, fList[position].name)
                    putExtra(FruitActivity.F_IMAGE, fList[position].imageId)
                }
                content.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = fList.size
}