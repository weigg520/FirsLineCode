package com.wzz.firstlinecode.chapter13
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @ClassName MyObserver
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/12 9:21
 * @Version 1.0
 */
class JetPackObserver(val lifecycle: Lifecycle) :LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.d("MyObserver", "activityStart: " + lifecycle.currentState)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d("MyObserver", "activityStop: "+ lifecycle.currentState)
    }
}