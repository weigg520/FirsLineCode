@file:Suppress("NAME_SHADOWING")

package com.wzz.firstlinecode.chapter11.kotlin

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

object HttpUtil {

    fun sendHttpRequest(address:String,listener: HttpCallbackListener) {
        thread {
            try {
                val response = StringBuilder()
                val url = URL(address)
                val connection = url.openConnection() as HttpURLConnection
                val input:InputStream = with(connection) {
                    connectTimeout = 8000
                    readTimeout = 8000
                    inputStream
                }
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                listener.onFinish(response.toString())
            }catch (e:Exception){
                e.printStackTrace()
                listener.onError(e)
            }
        }
    }

    fun sendOkHttpRequest(address: String,callback:okhttp3.Callback){
        thread {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(address)
                .build()
            client.newCall(request).enqueue(callback)
        }
    }

}

interface HttpCallbackListener{
    fun onFinish(response: String)
    fun onError(e: Exception)
}
