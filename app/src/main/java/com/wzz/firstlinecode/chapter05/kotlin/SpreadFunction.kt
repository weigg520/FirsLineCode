package com.wzz.firstlinecode.chapter05.kotlin

/**
 * @ClassName SpreadFunction
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/25 11:51
 * @Version 1.0
 */

fun main() {
    println("字母数量 ${"魏震zhou is very smart".lettersCount()}")
    val money = Money(1)
    val money2 = Money(2)
    val money3 = Money(3)
    val moneySum = money+money2+money3
    println(moneySum.value)
    val str = "adb" * 3
    println(str)
}