package com.wzz.firstlinecode.chapter11.retrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * @ClassName App
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/6 11:35
 * @Version 1.0
 */
class App(val id:String , val name :String , val version:String) {}
interface AppServices{
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}