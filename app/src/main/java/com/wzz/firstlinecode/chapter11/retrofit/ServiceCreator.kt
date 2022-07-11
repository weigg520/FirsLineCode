package com.wzz.firstlinecode.chapter11.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ClassName ServiceCreator
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/6 11:42
 * @Version 1.0
 */
object ServiceCreator {
    private const val BASE_URL = "http://www.xxx.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(servicesClass:Class<T>):T = retrofit.create(servicesClass)
    inline fun <reified T> create():T = create(T::class.java)
}