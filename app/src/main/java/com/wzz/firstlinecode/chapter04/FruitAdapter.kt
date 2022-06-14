package com.wzz.firstlinecode.chapter04

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

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
        val view = LayoutInflater.from(context).inflate(resourceId,parent,false)
        return super.getView(position, convertView, parent)
    }
}