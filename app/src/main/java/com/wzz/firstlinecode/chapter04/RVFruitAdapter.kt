package com.wzz.firstlinecode.chapter04

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wzz.firstlinecode.R

/**
 * @ClassName RVFruitAdapter
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/16 14:01
 * @Version 1.0
 */
class RVFruitAdapter(val fruitList:List<Fruit>) :RecyclerView.Adapter<RVFruitAdapter.ViewHolder>(){

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageView:ImageView = view.findViewById(R.id.item_iv)
        val textView:TextView = view.findViewById(R.id.item_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_fruits,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit:Fruit = fruitList[position]
        holder.imageView.setImageResource(fruit.imageId)
        holder.textView.text = fruit.name
    }

    override fun getItemCount() = fruitList.size
}