package com.wzz.firstlinecode.chapter12.kotlin

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.wzz.firstlinecode.chapter04.Fruit

/**
 * @ClassName KotlinStudyDemo
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/11 16:08
 * @Version 1.0
 */
fun max(vararg nums:Int):Int{
    var maxNumber = Int.MAX_VALUE
    for (num in nums){
        maxNumber = kotlin.math.max(maxNumber,num)
    }
    return maxNumber
}

fun <T:Comparable<T>> max(vararg nums: T):T{
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty.")
    var maxNum = nums[0]
    for (num in nums){
        if (num>maxNum){
            maxNum = num
        }
    }
    return maxNum
}

fun View.showSnackBar(text:String,actionStr:String,block:(() ->Unit)){
    val snackBar = Snackbar.make(this,text,Snackbar.LENGTH_LONG)
    snackBar.setAction(actionStr){
        block()
    }
    snackBar.show()
}

fun main() {
    val f1 = Fruit("香蕉",1)
    val f2 = Fruit("苹果蛋",2)
    println(max(f1,f2).name)
}