package com.wzz.firstlinecode.chapter04.kotlin

/**
 * 密封类，优化代码
 * @ClassName Result
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/20 15:51
 * @Version 1.0
 */
sealed class Result
class Success(val msg:String):Result()
class Failure(val error:Exception):Result()

fun getResultMsg(result: Result)=when(result){
    is Success -> result.msg
    is Failure -> result.error.message
}