package com.wzz.firstlinecode.chapter10.kotlin

import android.content.Context
import android.content.Intent

/**
 * @ClassName Reified
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 14:54
 * @Version 1.0
 */
inline fun <reified T> getGenericTypeX(){}
inline fun <reified T> getGenericType() = T::class.java
inline fun <reified T> launchActivity(context: Context,block:Intent.() -> Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}
inline fun <reified T> launchService(context: Context){
    val intent = Intent(context,T::class.java)
    context.startService(intent)
}

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}