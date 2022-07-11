package com.wzz.firstlinecode.chapter07

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter04.ToastUtils
import com.wzz.firstlinecode.chapter07.kotlin.cvOf
import kotlinx.android.synthetic.main.activity_sava.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.NullPointerException

class SaveActivity : AppCompatActivity() {
    private lateinit var dpHelper:MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dpHelper = MyDatabaseHelper(this,"BookStore",1)
        setContentView(R.layout.activity_sava)
        save.setOnClickListener {
            val inputTextStr = et.text.toString()
            save(inputTextStr)
            tv_load.text = ""
        }
        bt_load.setOnClickListener {
            tv_load.text = load()
            tv_sp.text = loadSp()
        }
        bt_sp.setOnClickListener {
            saveSp()
        }
        bt_sq.setOnClickListener {
            saveSQ()
        }
        bt_sq_add.setOnClickListener {
            addData()
        }
        bt_sq_updata.setOnClickListener {
            updateData()
        }
        bt_sq_delete.setOnClickListener {
            deleteData()
        }
        bt_sq_queryData.setOnClickListener {
            queryData()
        }
        bt_sq_transaction.setOnClickListener {
            transactionSuccessful()
        }
    }

    /**
     * 保存数据
     */
    private fun save(inputText:String){
        try {
            val outPut= openFileOutput("data",Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(outPut))
            writer.use {
                it.write(inputText)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 加载
     */
    private fun load():String{
        val content = StringBuilder()
        val inputText = openFileInput("data")
        val reader = BufferedReader(InputStreamReader(inputText))
        reader.use {
            reader.forEachLine {
                content.append(it)
            }
        }
        return content.toString()
    }

    private fun saveSp(){
        getSharedPreferences("data",Context.MODE_PRIVATE).edit(true) {
            putString("name","weizz")
            putInt("age",18)
            putBoolean("married",true)
        }
    }

    private fun loadSp():String{
        val editor = getSharedPreferences("data",Context.MODE_PRIVATE)
        val valueStr = StringBuilder()
        editor.apply {
            valueStr.append(getString("name",""))
            valueStr.append(getInt("age",0))
            valueStr.append(getBoolean("married",false))
        }
        return valueStr.toString()
    }

    private fun saveSQ(){
        dpHelper.writableDatabase
    }

    private fun addData(){
        val values = ContentValues().apply {
            put("name","第一行代码")
            put("author","郭霖")
            put("pages",808)
            put("price",50)
        }
        val data = cvOf("name" to "魏帅自传","author" to "魏晨" , "pages" to 808 , "price" to 50)
        val row =  dpHelper.writableDatabase.insert("Book",null,values)
        val row2 =  dpHelper.writableDatabase.insert("Book",null,data)
        ToastUtils.showToast("添加${row}")
        ToastUtils.showToast("添加${row2}")
    }

    private fun updateData(){
        val values = ContentValues().apply {
            put("price",80)
        }
        val row = dpHelper.writableDatabase.update("Book",values,"name = ?", arrayOf("第一行代码"))
        ToastUtils.showToast("更新${row}")
    }

    private fun deleteData(){
        val row = dpHelper.writableDatabase.delete("Book","pages > ?", arrayOf("800"))
        ToastUtils.showToast("删除${row}")
    }

    private fun queryData(){
        val cursor = dpHelper.writableDatabase.query("Book",
                null,null,null,null,null,null)
        if (cursor.moveToFirst()){
            do {
                cursor.apply {
                    Log.d("db", "name: " + getString(getColumnIndex("name")))
                    Log.d("db", "author: " + getString(getColumnIndex("author")))
                    Log.d("db", "pages: " + getString(getColumnIndex("pages")))
                    Log.d("db", "price: " + getString(getColumnIndex("price")))
                }
            }while (cursor.moveToNext())
        }
        cursor.close()
    }

    /**
     * 数据库事务
     */
    private fun transactionSuccessful(){
        //开启事务
        dpHelper.writableDatabase.beginTransaction()
        try {
            dpHelper.writableDatabase.delete("Book",null,null)
            if (true){
                throw NullPointerException()
            }
            val values = ContentValues().apply {
                put("name","Game of Thrones")
                put("author","George Martin")
                put("pages",720)
                put("price",20.85)
            }
            dpHelper.writableDatabase.insert("Book",null,values)
            dpHelper.writableDatabase.setTransactionSuccessful()
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            dpHelper.writableDatabase.endTransaction()
        }
    }
}