package com.wzz.firstlinecode.chapter04

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.wzz.firstlinecode.R

/**
 * @ClassName Fruit
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 17:39
 * @Version 1.0
 */
class FruitAdapter(activity: Activity,val resourceId:Int,data:List<Fruit>) :
    ArrayAdapter<Fruit>(activity,resourceId,data) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view:View
        var viewHolder:ViewHolder
        if (convertView == null){
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            val imageV = view.findViewById<ImageView>(R.id.item_iv)
            val textV = view.findViewById<TextView>(R.id.item_tv)
            viewHolder = ViewHolder(imageV,textV)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
        if (fruit!=null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }

    inner class ViewHolder(val fruitImage:ImageView , val fruitName:TextView)
}