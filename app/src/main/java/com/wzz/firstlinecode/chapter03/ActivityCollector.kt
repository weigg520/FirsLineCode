package com.wzz.firstlinecode.chapter03

import android.app.Activity

/**
 * @ClassName ActivityCollector
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 10:32
 * @Version 1.0
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            activity.finish()
        }
        activities.clear()
    }
}