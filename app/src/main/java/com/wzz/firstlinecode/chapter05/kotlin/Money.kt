package com.wzz.firstlinecode.chapter05.kotlin

/**
 * @ClassName Money
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/27 9:55
 * @Version 1.0
 */
class Money(val value:Int){

    operator fun plus(money: Money):Money{
        val sum = value + money.value
        return Money(sum)
    }

    operator fun plus(value: Int):Money{
        val sum = this.value+value
        return Money(sum)
    }

}