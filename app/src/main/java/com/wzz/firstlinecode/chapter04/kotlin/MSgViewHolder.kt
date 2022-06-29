package com.wzz.firstlinecode.chapter04.kotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wzz.firstlinecode.R

/**
 * @ClassName MSgViewHolder
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/21 11:39
 * @Version 1.0
 */
sealed class MSgViewHolder(view: View):RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View):MSgViewHolder(view){
    val leftView:TextView = view.findViewById(R.id.msgLeft)
}

class RightViewHolder(view:View):MSgViewHolder(view){
    val rightView:TextView = view.findViewById(R.id.msgRight)
}
