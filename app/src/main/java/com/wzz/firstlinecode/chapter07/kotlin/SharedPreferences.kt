package com.wzz.firstlinecode.chapter07.kotlin

import android.annotation.SuppressLint
import android.content.SharedPreferences

/**
 * @ClassName SharedPreferences
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/28 15:17
 * @Version 1.0
 */
fun SharedPreferences.open(block:SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.block()
    editor.apply()
}

@SuppressLint("ApplySharedPref")
fun SharedPreferences.mYEditor(commit:Boolean = false,
                               action:SharedPreferences.Editor.() ->Unit){
    val editor = edit()
    action(editor)
    if (commit){
        editor.commit()
    }else{
        editor.apply()
    }
}