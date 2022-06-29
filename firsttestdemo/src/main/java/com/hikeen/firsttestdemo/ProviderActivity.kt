package com.hikeen.firsttestdemo
import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_provider.*

class ProviderActivity : Activity() ,View.OnClickListener{
    private val uriStrPath = "content://com.wzz.firstlinecode.provider/book"
    private var bookId:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provider)
        bt_add.setOnClickListener(this)
        bt_query.setOnClickListener(this)
        bt_update.setOnClickListener(this)
        bt_delete.setOnClickListener(this)
    }

    private fun addData(){
        //添加数据
        val contentValues = contentValuesOf("name" to "A Clash of Kings",
            "author" to "George Martin", "pages" to 1040, "price" to 22.85)
        val uriValue = contentResolver.insert(Uri.parse(uriStrPath),contentValues)
        bookId = uriValue?.pathSegments?.get(1)
        Log.e("ProviderActivity", "bookId: $bookId")
    }

    private fun updateData(){
        //更新数据
        bookId?.let {
            val uri = Uri.parse("$uriStrPath/$it")
            val values = contentValuesOf("name" to "A Storm of Swords",
                "pages" to 1216, "price" to 24.05)
            val id = contentResolver.update(uri,values,null,null)
            Log.e("ProviderActivity", "updateData: $id" )
        }
    }

    private fun queryData() {
        //查询
        val uri = Uri.parse(uriStrPath)
        contentResolver.query(uri, null, null, null, null)?.apply {
            while (moveToNext()) {
                Log.e(
                    "ProviderActivity", "book name: "
                            + getString(getColumnIndex("name"))
                )
                Log.e(
                    "ProviderActivity", "book author: "
                            + getString(getColumnIndex("author"))
                )
                Log.e(
                    "ProviderActivity", "book price: "
                            + getString(getColumnIndex("price"))
                )
                Log.e(
                    "ProviderActivity", "book pages: "
                            + getString(getColumnIndex("pages"))
                )
            }
            close()
        }
    }


    private fun deleteData(){
        //删除数据
        bookId?.let {
            val uri = Uri.parse("$uriStrPath/$it")
            contentResolver.delete(uri,null,null)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_add -> {
                addData()
            }
            R.id.bt_update -> {
                updateData()
            }
            R.id.bt_query -> {
                queryData()
            }
            R.id.bt_delete -> {
                deleteData()
            }
        }
    }

}