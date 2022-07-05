package com.wzz.firstlinecode.chapter09.kotlin

import androidx.core.content.contentValuesOf

/**
 * @ClassName infix
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/4 14:58
 * @Version 1.0
 */
infix fun String.beginsWith(prefix : String) = startsWith(prefix)
infix fun <T> Collection<T>.has(element:T) = contains(element)
infix fun<A,B> A.with(that : B):Pair<A,B> = Pair(this,that)

fun main() {
    val startW = "Hello world" beginsWith "hello"
    val cts = listOf("苹果","香蕉","梨子") has "香蕉"
    val mapOf = mapOf("小明" with "帅哥" , "阿魏" with "尚可")
}