package com.wzz.firstlinecode.chapter04

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_ui.*

/**
 * @ClassName UIActivity
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/14 14:32
 * @Version 1.0
 */
class UIActivity :BaseActivity(), View.OnClickListener{
    private lateinit var alertDialog:AlertDialog.Builder
    private val fruits = listOf("banana","durian","kiwi_fruit","lemon","pears","watermelon")

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)
        supportActionBar?.hide()
        alertDialog = alertDialog()
        changeTvColorAndSize()
        addBnOnClick()
        changeEt()
        changeImageView()
        changeProgressBar()
        alertDialog()
    }

    private fun changeTvColorAndSize(){
        ui_tv.run {
            setTextColor(ContextCompat.getColor(context,R.color.colorPrimaryDark))
            textSize = 50f
        }
    }

    private fun addBnOnClick(){
        //第一种
       /* ui_bn.setOnClickListener {
            //此处添加单击逻辑
        }*/
        //第二种
        ui_bn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
           R.id.ui_bn->{
               //此处添加单击逻辑
               val inputEt = ui_et.text.toString()
               ToastUtils.showToast(inputEt)
               ui_iv.setImageResource(R.drawable.white)
               ui_pb.progress = ui_pb.progress+10
               alertDialog.show()
           }
        }
    }

    private fun changeEt(){
        ui_et.apply {
            hint = "描述某一些事务"
            maxLines = 2
        }
    }

    private fun changeImageView(){
        ui_iv.apply {
            setImageResource(R.mipmap.ic_launcher)
        }
    }

    private fun changeProgressBar(){
        ui_pb.apply {
            max = 100
            progress = 50
        }
    }

    private fun alertDialog():AlertDialog.Builder{
        return AlertDialog.Builder(this).run {
            setTitle("这是一个弹窗")
            setMessage("这里放一些信息")
            setPositiveButton("好"){dialog, which ->
                ToastUtils.showToast("好被点击了")
            }
            setNegativeButton("不"){ _, _ ->
                ToastUtils.showToast("不被点击了")
            }
        }
    }

    fun listViewTest(){
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,fruits)
        ui_lv.adapter = adapter
    }
}