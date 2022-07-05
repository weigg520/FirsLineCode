package com.wzz.firstlinecode.chapter10

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.wzz.firstlinecode.MainActivity
import com.wzz.firstlinecode.R

class MyService : Service() {
    companion object{
        val TAG :String = MyService::class.java.name
    }

    private val mBinder = DownloadBinder()

    class DownloadBinder : Binder(){
        fun startDownload(){
            Log.e(TAG, "startDownload: ")
        }
        fun getProgress(){
            Log.e(TAG, "getProgress: " )
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate: executed")
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("my_service","前台Service通知",
                NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this,MainActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"my_service")
            .setContentTitle("This is content title")
            .setContentText("这是内容")
            .setSmallIcon(R.drawable.pears)
            .setAutoCancel(true)
            .setContentIntent(pi).build()
        startForeground(1,notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "onStartCommand: executed")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: executed")
    }
}