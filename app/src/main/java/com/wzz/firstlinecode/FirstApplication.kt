package com.wzz.firstlinecode

import android.app.Application
import com.wzz.firstlinecode.chapter04.ToastUtils

/**
 * @ClassName FristAppliction
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 16:54
 * @Version 1.0
 */
class FirstApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        ToastUtils.initToastUtils(this)
    }
}