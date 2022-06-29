package com.wzz.firstlinecode.chapter07

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.wzz.firstlinecode.chapter04.ToastUtils

/**
 * @ClassName MyDatabaseHelper
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/27 17:21
 * @Version 1.0
 */
class MyDatabaseHelper(val context: Context,name:String,version:Int):
    SQLiteOpenHelper(context,name,null,version) {

    private val createBook = "create table Book (" +
            "id integer primary key autoincrement,"+
            "author text,"+
            "price real,"+
            "pages integer,"+
            "name text,"+
            "category_id integer)"

    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        db?.execSQL(createCategory)
        ToastUtils.showToast("创建成功")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion<=1){
            db?.execSQL(createCategory)
        }
        if (oldVersion<=2){
            db?.execSQL("alter table Book add column category_id integer")
        }
    }
}