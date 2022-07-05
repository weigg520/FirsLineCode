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
@SuppressLint("StaticFieldLeak")
object ToastUtils {

    private var context:Context? = null

    private val toast by lazy {
        context?.let {
            Toast.makeText(it,"",Toast.LENGTH_SHORT)
        }
    }

    @SuppressLint("ShowToast")
    fun initToastUtils(context: Context){
        this.context = context
    }

    fun showToast(content:String){
        toast?.let {
            it.setText(content)
            it.show()
        }
    }

}