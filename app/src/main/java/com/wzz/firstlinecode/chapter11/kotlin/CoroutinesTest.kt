package com.wzz.firstlinecode.chapter11.kotlin

import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @ClassName CoroutinesTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 18:02
 * @Version 1.0
 */

suspend fun printDot(){
    println(".")
    delay(1000)
}

suspend fun printDotCoroutineScope() = coroutineScope{
    launch {
        println(".")
        delay(1000)
    }
}

fun coroutinesDemonstration(){
    val job = Job()
    val scope = CoroutineScope(job)
    val start = System.currentTimeMillis()
    var x:Deferred<Int>
    scope.launch {
        x = async {
            4 + 5
        }
        println("数据: ${x.await()}")
    }
    val end = System.currentTimeMillis()
    println( " 结束:${end - start}")
    job.cancel()
}

suspend fun request(address:String):String{
    return suspendCoroutine { continuation ->
        HttpUtil.sendHttpRequest("http://www.baidu.com",object:HttpCallbackListener{
            override fun onFinish(response: String) {
                continuation.resume(response)
            }

            override fun onError(e: Exception) {
                continuation.resumeWithException(e)
            }
        })

    }
}


fun main() {
    GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }
    Thread.sleep(1000)
    println("测试")
    coroutinesDemonstration()
}