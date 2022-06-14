package com.wzz.firstlinecode.chapter04

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * @ClassName ToastUtils
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 16:48
 * @Version 1.0
 */
object ToastUtils {
    private lateinit var toast: Toast

    @SuppressLint("ShowToast")
    fun initToastUtils(context: Context){
        toast =  Toast.makeText(context,"",Toast.LENGTH_SHORT)
    }

    fun showToast(content:String){
        toast.apply {
            setText(content)
            show()
        }
    }

}