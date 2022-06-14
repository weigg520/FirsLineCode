package com.wzz.firstlinecode.chapter03.kotlin

import java.lang.StringBuilder

/**
 * @ClassName WithAndRunAndApply
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 11:30
 * @Version 1.0
 */
class WithAndRunAndApply {
    private val fruits = listOf("香蕉","苹果","橘子","桃子")
    private val builder = StringBuilder()
    private val startEat = "我开始吃水果了。。。\n"
    private val endEat = "水果被我吃完了！"

    fun forTest():String{
        builder.append(startEat)
        for (fruit in fruits){
            builder.append(fruit).append("\n")
        }
        builder.append(endEat)
        return builder.toString()
    }


    fun withTest():String{
        return with(builder){
            append(startEat)
            for (fruit in fruits){
                append(fruit).append("\n")
            }
            append(endEat)
            toString()
        }
    }

    fun runTest():String{
        return builder.run {
            append(startEat)
            for (fruit in fruits){
                append(fruit).append("\n")
            }
            append(endEat)
            toString()
        }
    }

    fun applyTest():String{
        return builder.apply {
            append(startEat)
            for (fruit in fruits){
                append(fruit).append("\n")
            }
            append(endEat)
        }.toString()
    }
}

fun main() {
    val withAndRunAndApply = WithAndRunAndApply()
    println(withAndRunAndApply.applyTest())
    Utils().doAction1()
    Utils.doAction2()
    Utils.doAction3()
    doSomething()
}