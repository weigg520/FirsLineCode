package com.wzz.firstlinecode.chapter03

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wzz.firstlinecode.R
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.second.*

/**
 * @ClassName FristActivity
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/13 14:51
 * @Version 1.0
 */
class FirstActivity :BaseActivity(){

    val action:String = "com.wzz.firstlinecode.chapter03.ACTION_START"
    val category:String = "android.intent.category.MY_CATEGORY"

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        first_bt.setOnClickListener {
            Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show()
            //显示
            val intent = Intent(this,SecondActivity::class.java)
            //隐式
            val intentAction = Intent(action)
            intentAction.addCategory(category)
            //startActivity(httpsAction)
            SecondActivity.actionStart(this,"https://www.weixin.com")
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add ->
                Toast.makeText(this,"添加",Toast.LENGTH_SHORT).show()
            R.id.remove->{
                Toast.makeText(this,"删除",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return true
    }
    override fun onBackPressed() {
        /*if (!web_view.canGoBack()){
            super.onBackPressed()
        }*/
    }
}