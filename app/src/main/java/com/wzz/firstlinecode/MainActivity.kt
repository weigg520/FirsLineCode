package com.wzz.firstlinecode
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter03.FirstActivity
import com.wzz.firstlinecode.chapter04.UIActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_c3.setOnClickListener(this)
        bt_c4.setOnClickListener(this)
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
        }
    }
}