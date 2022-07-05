package com.wzz.firstlinecode.chapter08.kotlin

/**
 * @ClassName Later
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/30 16:20
 * @Version 1.0
 */
fun <T> later(block:() -> T) = Later(block)