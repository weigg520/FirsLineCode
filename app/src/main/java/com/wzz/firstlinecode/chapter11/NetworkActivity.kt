package com.wzz.firstlinecode.chapter11
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter11.kotlin.HttpUtil
import com.wzz.firstlinecode.chapter11.kotlin.request
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread


class NetworkActivity : AppCompatActivity() {

    private var client = OkHttpClient()
    private val request = Request.Builder()
        .url("https://www.baidu.com")
        .build()
    private val requestBody = FormBody.Builder()
        .add("username", "admin")
        .add("password", "123456")
        .build()
    private val requestBodyData = Request.Builder()
        .url("https://www.baidu.com")
        .post(requestBody)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        start_http.setOnClickListener {
            GlobalScope.launch {
                val result = request("https:www.baidu.com")
                runOnUiThread {
                    tv1.setHtml(result)
                }
            }
        }

    }


}