package com.wzz.firstlinecode.chapter13

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_jetpack.*

class JetPackActivity : BaseActivity() {
    lateinit var viewModel:JetPackModelView
    lateinit var sp:SharedPreferences
    val countReservedKey:String = "count_reserved"

    override fun getContentViewId() = R.layout.activity_jetpack

    override fun initView() {
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt(countReservedKey,0)
        //默认参数
        viewModel = ViewModelProvider(this,JetPackViewModelFactory(countReserved))
                .get(JetPackModelView::class.java)
        plus_one.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
        clear.setOnClickListener {
            viewModel.counter = 0
            refreshCounter()
        }
        refreshCounter()
    }

    /**
     * 刷新
     */
    private fun refreshCounter(){
        num.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt(countReservedKey,viewModel.counter)
        }
    }
}