package com.wzz.firstlinecode.chapter03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.wzz.firstlinecode.BaseViewInit
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter04.ToastUtils
import com.wzz.firstlinecode.chapter12.kotlin.showSnackBar
import com.wzz.firstlinecode.chapter13.JetPackObserver
import kotlinx.android.synthetic.main.toolbar_base.*

/**
 * @ClassName BaseActivity
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 10:30
 * @Version 1.0
 */
abstract class BaseActivity :AppCompatActivity(),BaseViewInit{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_base)
        setSupportActionBar(toolbar)
        LayoutInflater.from(this).inflate(getContentViewId(),content)
        ActivityCollector.addActivity(this)
        initView()
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.watermelon)
        }
        fab.setOnClickListener {
            it.showSnackBar("删除","取消"){
                ToastUtils.showToast("取消删除操作")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fruits,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> drawer_layout.openDrawer(GravityCompat.START)
            R.id.banana ->ToastUtils.showToast("香蕉")
            R.id.pears ->ToastUtils.showToast("梨子")
            R.id.lemon -> ToastUtils.showToast("柠檬")
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    abstract fun getContentViewId():Int
}