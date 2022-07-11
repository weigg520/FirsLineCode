package com.wzz.firstlinecode.chapter13

import androidx.lifecycle.ViewModel

/**
 * @ClassName JetPackModelView
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/11 17:18
 * @Version 1.0
 */
class JetPackModelView(countReserved:Int) : ViewModel(){
    var counter = countReserved
}