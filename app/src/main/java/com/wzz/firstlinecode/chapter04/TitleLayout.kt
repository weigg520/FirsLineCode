package com.wzz.firstlinecode.chapter04

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.wzz.firstlinecode.R
import kotlinx.android.synthetic.main.title.view.*

/**
 * @ClassName TitleLayout
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 16:30
 * @Version 1.0
 */
class TitleLayout(context: Context,attrs: AttributeSet) : LinearLayout(context,attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)
        bt_t_menu.setOnClickListener{
            ToastUtils.showToast("点击了菜单按钮")
        }
        bn_t_back.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
    }
}