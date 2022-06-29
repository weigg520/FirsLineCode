package com.wzz.firstlinecode.chapter06

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.wzz.firstlinecode.chapter04.ToastUtils

/**
 * @ClassName MyBroadcastReceiver
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/27 14:31
 * @Version 1.0
 */
class MyBroadcastReceiver :BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        ToastUtils.showToast("自定义广播")
    }
}