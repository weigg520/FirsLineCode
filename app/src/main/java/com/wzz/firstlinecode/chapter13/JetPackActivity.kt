package com.wzz.firstlinecode.chapter13

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_jetpack.*
import kotlin.concurrent.thread
import kotlin.text.StringBuilder

@Suppress("UNNECESSARY_SAFE_CALL")
class JetPackActivity : BaseActivity() {
    //ModelView 不能直接创建
    lateinit var viewModel:JetPackModelView
    lateinit var sp:SharedPreferences
    val countReservedKey:String = "count_reserved"
    lateinit var userDao:UserDao

    override fun getContentViewId() = R.layout.activity_jetpack

    override fun initView() {
        userDao = AppDatabase.getDatabase(this).userDao()
        //添加生命周期监听
        lifecycle.addObserver(JetPackObserver(lifecycle))
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt(countReservedKey,0)
        //默认参数，使用提供者获取对象
        viewModel = ViewModelProvider(this,JetPackViewModelFactory(countReserved))
                .get(JetPackModelView::class.java)
        plus_one.setOnClickListener {
            viewModel.plusOne()
            val userId = (0..10000).random().toString()
            viewModel.getUserId(userId)
        }
        clear.setOnClickListener {
            viewModel.clear()
        }
        viewModel.counter.observe(this, Observer {
            num.text = it.toString()
        })
        viewModel.userName.observe(this, Observer {
            name.text = it
        })
        viewModel.user.observe(this, Observer {
            user.text = it.name
        })
        var userId:Long =0
        add.setOnClickListener {
            thread {
                userId = userDao.insertUser(User("桃木",20))
            }
        }
        update.setOnClickListener {
            thread {
             userDao.loadUserById(userId)?.let {
                 it.name = "魏晨"
                 userDao.updateUser(it)
             }
            }
        }
        select.setOnClickListener {
            thread {
                val strB = StringBuilder()
                for (user in userDao.loadAllUsers()){
                    strB.append("${user.name},${user.age},${user.id}")
                }
                viewModel.getUserId(strB.toString())
            }
        }
        delete.setOnClickListener {
            thread {
                userDao.deleteByUserId("魏晨")
            }
        }
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
            putInt(countReservedKey,viewModel.counter.value?:0)
        }
    }
}