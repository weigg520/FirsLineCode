package com.wzz.firstlinecode.chapter09

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.NotificationCompat
import androidx.core.content.FileProvider
import com.wzz.firstlinecode.MainActivity
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_multimedia.*
import java.io.File

class MultimediaActivity : AppCompatActivity() {

    companion object{
        const val NOTIFICATION_MY_ACTION:String = "MY_NOTIFICATION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multimedia)
        createNotification()
        createNotificationX()
        bt_send_notification.setOnClickListener {
            sendNotification()
        }
        tackPhoto()
    }

    private val notificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private var notification:Notification? = null

    /**
     * 创建通知8.0
     */
    private fun createNotification(){
        //获取通知服务
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val change =  NotificationChannel("110","报警",
                NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(change)
        }
    }

    /**
     * android X 库兼容版本
     */
    private fun createNotificationX(){
        val intent = Intent(this,MainActivity::class.java).apply {
            action = NOTIFICATION_MY_ACTION
        }
        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)
        notification = NotificationCompat.Builder(baseContext,"110")
            .setContentTitle("这是标题")
            .setContentText("")
            /*.setStyle(NotificationCompat.BigTextStyle()
                .bigText("这是内容\n白日依山尽\n黄河入海流\n欲穷千里目\n更上一层楼\n"))*/
            .setStyle(NotificationCompat.BigPictureStyle().bigLargeIcon(
                BitmapFactory.decodeResource(resources,R.drawable.yuan)
            ).bigPicture(BitmapFactory.decodeResource(resources,R.drawable.yuan)))
            .setSmallIcon(R.drawable.pears)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.watermelon))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
    }

    private fun sendNotification(){
        notification?.let {
            notificationManager.notify(1,it)
        }
    }

    val takePhoto = 1
    lateinit var imageUri:Uri
    lateinit var outputImage:File

    /**
     * 拍照
     */
    private fun tackPhoto(){
        bt_takePhoto.setOnClickListener {
            outputImage = File(externalCacheDir,"output_image.jpg")
            if (outputImage.exists()){
                outputImage.delete()
            }
            outputImage.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                FileProvider.getUriForFile(this,
                    "com.example.cameraalbumtest.fileprovider",outputImage)
            }else{
                Uri.fromFile(outputImage)
            }
            //启动相机程序
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri)
            startActivityForResult(intent,takePhoto)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            takePhoto ->{
                if (resultCode == Activity.RESULT_OK){
                    //将拍摄的照片显示出来
                    val bitmap = BitmapFactory.decodeStream(contentResolver
                        .openInputStream(imageUri))
                    im_photo.setImageBitmap(bitmap)
                }
            }
        }
    }
}