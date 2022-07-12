package com.wzz.firstlinecode.chapter13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @ClassName Repository
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/12 15:49
 * @Version 1.0
 */
object Repository {

    fun getUser(userId :String):LiveData<User>{
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId,0)
        return liveData
    }

}