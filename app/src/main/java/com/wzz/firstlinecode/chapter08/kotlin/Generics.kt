package com.wzz.firstlinecode.chapter08.kotlin

/**
 * @ClassName Generics
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/29 14:50
 * @Version 1.0
 */
class MyClass<T>{

    fun method(param:T):T{
        return param
    }

    fun <X> methodX(param: X):X{
        return param
    }

    fun <N : Number> methodN(param: N):N{
        return param
    }
}

fun <T> T.build(block:T.()->Unit):T{
    block()
    return this
}

fun main() {
    MyClass<String>().build {
        println(method("魏震洲"))
        println(methodX(123))
        println(methodN(123))
    }
}