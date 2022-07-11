package com.wzz.firstlinecode.chapter08

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_content_provider.*
import java.lang.Exception

class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        bt_make_call.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:10086")
                startActivity(intent)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    /**
     * 查询
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun contentResolverQuery(){
        /**
         * uri 指定查询某个应用程序下的某一张表[from table_name]
         * projection 指定查询的列名 [select column1, column2]
         * selection 指定where的约束条件 [where column = value]
         * selectionArgs 为where中的占位符提供具体的值
         * sortOrder 指定查询结果的排序方式 [order by column1, column2]
         */
        val cursor = contentResolver.query(uri,null,null,null)
        while (cursor?.moveToNext() == true){
            val column1 = cursor.getString(cursor.getColumnIndex("column1"))
            val column2 = cursor.getInt(cursor.getColumnIndex("column2"))
        }
        cursor?.close()
    }

    /**
     * 插入
     */
    fun contentResolverInsert(){
        val values = contentValuesOf("column1" to "text" , "column2" to 1)
        contentResolver.insert(uri,values)
    }

    /**
     * 更新
     */
    fun contentResolverUpdate(){
        val values = contentValuesOf("column1" to "")
        contentResolver.update(uri,values,"column1 = ? and column2 = ?", arrayOf("text","1"))
    }

    /**
     * 删除
     */
    fun contentResolverDelete(){
        contentResolver.delete(uri,"column2 = ?" , arrayOf("1"))
    }
}