package com.wzz.firstlinecode.chapter03.kotlin

/**
 * @ClassName Utils
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 14:14
 * @Version 1.0
 */
class Utils {

    fun doAction1(){
        println("普通的方法")
    }

    companion object{
        fun doAction2(){
            println("伴生方法,不是真正的静态方法")
        }

        @JvmStatic
        fun doAction3(){
            println("真正的静态方法，需要注解")
        }
    }
}