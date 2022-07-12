package com.wzz.firstlinecode.chapter13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @ClassName JetPackModelView
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/11 17:18
 * @Version 1.0
 */
class JetPackModelView(countReserved:Int) : ViewModel(){

    val  counter = MutableLiveData<Int>()
    private val userLiveData = MutableLiveData<User>()
    private val userIdLiveData = MutableLiveData<String>()

    init {
        counter.value = countReserved
    }

    val userName:LiveData<String> = Transformations.map(userLiveData){
        "你的名字${it.name}，年龄${it.age}"
    }

    fun plusOne(){
        val count = counter.value?:0
        counter.value = count+1
        userLiveData.value = User("userName",count)
    }

    fun postRunOne(){
        val count = counter.value?:0
        //如果在线程需要使用postValue
        counter.postValue(count+1)
    }

    fun clear(){
        counter.value = 0
        userLiveData.value = User("",0)
    }

    val user:LiveData<User> = Transformations.switchMap(userIdLiveData){
        Repository.getUser(it)
    }

    fun getUserId(userId:String){
        userIdLiveData.postValue(userId)
    }
}