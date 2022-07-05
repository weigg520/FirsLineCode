package com.wzz.firstlinecode
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter03.FirstActivity
import com.wzz.firstlinecode.chapter04.ToastUtils
import com.wzz.firstlinecode.chapter04.UIActivity
import com.wzz.firstlinecode.chapter05.FragmentActivity
import com.wzz.firstlinecode.chapter06.BroadcastReceiverActivity
import com.wzz.firstlinecode.chapter07.SaveActivity
import com.wzz.firstlinecode.chapter08.ContentProviderActivity
import com.wzz.firstlinecode.chapter09.MultimediaActivity
import com.wzz.firstlinecode.chapter10.ServiceActivity
import com.wzz.firstlinecode.chapter10.kotlin.launchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        judgeNotification(intent)
        bt_c3.setOnClickListener(this)
        bt_c4.setOnClickListener(this)
        bt_c5.setOnClickListener(this)
        bt_c6.setOnClickListener(this)
        bt_c7.setOnClickListener(this)
        bt_c8.setOnClickListener(this)
        bt_c9.setOnClickListener(this)
        bt_c10.setOnClickListener(this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        judgeNotification(intent)
    }

    /**
     * 检测是否为Notification跳转
     */
    private fun judgeNotification(intent:Intent?){
        intent?.let {
            if (it.action.equals(MultimediaActivity.NOTIFICATION_MY_ACTION)){
                ToastUtils.showToast("这是从通知栏过来的")
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_c3->{
                startActivity(Intent(this,FirstActivity::class.java))
                finish()
            }
            R.id.bt_c4->{
                startActivity(Intent(this,UIActivity::class.java))
                finish()
            }
            R.id.bt_c5->{
                startActivity(Intent(this,FragmentActivity::class.java))
                finish()
            }
            R.id.bt_c6->{
                startActivity(Intent(this,BroadcastReceiverActivity::class.java))
                finish()
            }
            R.id.bt_c7->{
                startActivity(Intent(this,SaveActivity::class.java))
                finish()
            }
            R.id.bt_c8->{
                startActivity(Intent(this,ContentProviderActivity::class.java))
                finish()
            }
            R.id.bt_c9->{
                startActivity(Intent(this,MultimediaActivity::class.java))
                finish()
            }
            R.id.bt_c10->{
                launchActivity<ServiceActivity>(this){

                }
            }
        }
    }
}