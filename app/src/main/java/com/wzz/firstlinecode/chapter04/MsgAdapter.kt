package com.wzz.firstlinecode.chapter04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter04.kotlin.LeftViewHolder
import com.wzz.firstlinecode.chapter04.kotlin.MSgViewHolder
import com.wzz.firstlinecode.chapter04.kotlin.RightViewHolder

/**
 * @ClassName MsgAdapter
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/20 14:00
 * @Version 1.0
 */
class MsgAdapter(private val msgList:List<Msg>):RecyclerView.Adapter<MSgViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MSgViewHolder =
        if (viewType == Msg.TYPE_RECEIVED){
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_left_msg,parent,false)
            LeftViewHolder(view)
    }else{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_right_msg,parent,false)
            RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: MSgViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftView.text = msg.content
            is RightViewHolder -> holder.rightView.text = msg.content
        }
    }

    override fun getItemCount() = msgList.size
}