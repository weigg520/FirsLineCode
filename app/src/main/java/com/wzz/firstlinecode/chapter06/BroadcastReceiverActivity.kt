package com.wzz.firstlinecode.chapter06

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter04.ToastUtils
import kotlinx.android.synthetic.main.activity_broadcat_receiver.*

class BroadcastReceiverActivity : AppCompatActivity() {
    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcat_receiver)
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver,intentFilter)
        send_my_broadcast.setOnClickListener {
            val initIntent = Intent("android.intent.action.MY_BROADCAST_RECEIVER")
            initIntent.setPackage(packageName)
            sendBroadcast(initIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            ToastUtils.showToast("Time has changed")
        }
    }
}