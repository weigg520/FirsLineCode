package com.wzz.firstlinecode.chapter03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassName BaseActivity
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 10:30
 * @Version 1.0
 */
open class BaseActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}