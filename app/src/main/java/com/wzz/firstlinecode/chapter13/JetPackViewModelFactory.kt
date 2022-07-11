package com.wzz.firstlinecode.chapter13

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @ClassName MainViewModelFactory
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/11 17:48
 * @Version 1.0
 */
@Suppress("UNCHECKED_CAST")
class JetPackViewModelFactory(private val countReserved:Int):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JetPackModelView(countReserved) as T
    }
}