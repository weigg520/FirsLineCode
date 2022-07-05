package com.wzz.firstlinecode.chapter10

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * @ClassName MyIntentService
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 14:30
 * @Version 1.0
 */
class MyIntentService :IntentService("MyIntentService"){

    override fun onHandleIntent(intent: Intent?) {
        //打印当前线程
        Log.d("MyIntentService",
            "onHandleIntent: Thread is ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyIntentService", "onDestroy: executed")
    }
}