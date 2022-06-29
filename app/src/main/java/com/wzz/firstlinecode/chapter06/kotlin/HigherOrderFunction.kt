package com.wzz.firstlinecode.chapter06.kotlin

/**
 * @ClassName HigherOrderFunction
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/27 14:48
 * @Version 1.0
 */
class HigherOrderFunction {

    fun example(func:(String,Int) ->Unit){
        func("hello",123)
    }

    fun num1AndNum2(num1:Int, num2: Int, operation:(Int,Int)-> Int):Int{
        return operation(num1,num2)
    }

}

fun main(){
    val num1 = 100
    val num2 = 200
    val higherOrderFunction = HigherOrderFunction()
    higherOrderFunction.example { s, _ ->
        println(s)
    }
    val r1 = higherOrderFunction.num1AndNum2(num1,num2){n1,n2->
        n1+n2
    }
    val r2 = higherOrderFunction.num1AndNum2(num1,num2){n1,n2->
        n1-n2
    }
    println("高阶函数${r1},${r2}")
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruits in list){
            append(fruits).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
    println("main start")
    val str ="2"
    printString(str){
        println("lambda start")
        if (it.isEmpty())return@printString
        println(it)
        println("lambda end")
    }
    println("main end")
}


fun printString(str:String,block:(String)->Unit){
    println("printString begin")
    block(str)
    println("printString end")
}

fun plus(num1: Int,num2: Int):Int{
    return num1+num2
}

fun minus(num1: Int,num2: Int):Int{
    return num1-num2
}

inline fun StringBuilder.build(block:StringBuilder.() -> Unit):StringBuilder{
    block()
    return this
}

inline fun runRunnable(crossinline block:()->Unit){
    val runnable = Runnable {
        block()
    }
    runnable.run()
}
