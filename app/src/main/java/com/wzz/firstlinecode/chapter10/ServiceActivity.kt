package com.wzz.firstlinecode.chapter10

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter10.kotlin.launchService
import kotlinx.android.synthetic.main.activity_service.*
import kotlin.concurrent.thread

class ServiceActivity : AppCompatActivity() {

    private val updateText = 1
    private val handler:Handler = @SuppressLint("HandlerLeak")
    object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                updateText->{
                    tv_title.text = "见到你狠高兴"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        bt_send.setOnClickListener {
            thread {
                handler.sendEmptyMessage(updateText)
            }
            DownloadTask(ProgressDialog(this)).execute()
        }
        start_service.setOnClickListener {
            if (start_service.text.equals("启动服务")){
                start_service.text = "停止服务"
                startService(Intent(this,MyService::class.java))
            }else{
                stopService(Intent(this,MyService::class.java))
                start_service.text = "启动服务"
            }
        }
        bind_service.setOnClickListener {
            if (bind_service.text.equals("绑定服务")){
                bind_service.text = "解绑服务"
                bindService(Intent(this,MyService::class.java),connection,Context.BIND_AUTO_CREATE)
            }else{
                unbindService(connection)
                bind_service.text = "绑定服务"
            }
        }
        start_intent_service.setOnClickListener {
            Log.d("MyIntentService", "Thread id is ${Thread.currentThread().name}")
            launchService<MyIntentService>(this)
            //startService(Intent(this,MyIntentService::class.java))
        }
    }

    lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder  = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }


}