package com.wzz.firstlinecode.chapter06

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.wzz.firstlinecode.MainActivity

/**
 * @ClassName BootCompleteReceiver
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/27 13:40
 * @Version 1.0
 */
class BootCompleteReceiver :BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        val intentAction = Intent(context,MainActivity::class.java)
        intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intentAction)
        Log.e("BootCompleteReceiver", "onReceive BOOT_COMPLETED: 开机自启" )
    }

}