package com.wzz.firstlinecode.chapter04

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val fruits = listOf("香蕉","榴莲","猕猴桃","柠檬","梨子","西瓜")

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
        initFruitsData()
        listViewTest()
        rvTest()
        startChat()
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

    private val fruitListData = ArrayList<Fruit>()

    fun listViewTest(){
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,fruits)
        val fruitAdapter = FruitAdapter(this,R.layout.item_fruits,fruitListData)
        ui_lv.adapter = fruitAdapter
        ui_lv.setOnItemClickListener { _, _, position, _ ->
            val fruit:Fruit = fruitListData[position]
            ToastUtils.showToast(fruit.name)
        }
    }

    fun rvTest(){
        val fruitAdapter = RVFruitAdapter(fruitListData)
        ui_rv.layoutManager = GridLayoutManager(this,3).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        ui_rv.adapter = fruitAdapter
    }

    private fun initFruitsData(){
        repeat(3){
            fruitListData.add(Fruit("香蕉",R.drawable.banana))
            fruitListData.add(Fruit("猕猴桃",R.drawable.kiwi_fruit))
            fruitListData.add(Fruit("榴莲",R.drawable.durian))
            fruitListData.add(Fruit("柠檬",R.drawable.lemon))
            fruitListData.add(Fruit("芒果",R.drawable.mango))
            fruitListData.add(Fruit("西瓜",R.drawable.watermelon))
            fruitListData.add(Fruit("梨子",R.drawable.pears))
        }
    }


    private fun startChat(){
        start_chat.setOnClickListener {
            startActivity(Intent(this,ChatActivity::class.java))
        }
    }
}