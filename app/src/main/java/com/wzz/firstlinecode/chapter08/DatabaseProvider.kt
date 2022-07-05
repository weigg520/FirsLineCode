package com.wzz.firstlinecode.chapter08

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri
import com.wzz.firstlinecode.chapter07.MyDatabaseHelper
import com.wzz.firstlinecode.chapter08.kotlin.later

/**
 * @ClassName DatabaseProvider
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/28 17:36
 * @Version 1.0
 */
class DatabaseProvider :ContentProvider() {

    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "com.wzz.firstlinecode.provider"
    private var dbHelper:MyDatabaseHelper? =null

    private val uriMatcher by later{
        UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(authority,"book",bookDir)
            addURI(authority,"book/#",bookItem)
            addURI(authority,"category",categoryDir)
            addURI(authority,"category/#",categoryItem)
        }
    }

    override fun onCreate() = context?.let {
        dbHelper = MyDatabaseHelper(it,"BookStore.db",2)
        true
    }?:false

    @SuppressLint("Recycle")
    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    )=dbHelper?.let {
        val dp = it.readableDatabase
        val cursor = when(uriMatcher.match(uri)){
            bookDir -> dp.query("Book",projection,selection,selectionArgs,
                null,null,sortOrder)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                dp.query("Book",projection,"id = ?" , arrayOf(bookId),
                    null,null,sortOrder)
            }
            categoryDir -> dp.query("Category",projection,selection,selectionArgs,
                null,null,sortOrder)
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                dp.query("Category",projection,"id = ?" , arrayOf(categoryId),
                    null,null,sortOrder)
            }
            else -> null
        }
        cursor
    }

    override fun getType(uri: Uri)= when(uriMatcher.match(uri)){
        bookDir -> "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.book"
        bookItem -> "vnd.android.cursor.item/vnd.com.example.databasetest.provider.book"
        categoryDir -> "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.category"
        categoryItem -> "vnd.android.cursor.item/vnd.com.example.databasetest.provider.category"
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper?.let {
        //添加数据
        val db = it.writableDatabase
        val uriReturn = when(uriMatcher.match(uri)){
            bookDir,bookItem ->{
                val newBookId = db.insert("Book",null,values)
                Uri.parse("content://$authority/book/$newBookId")
            }
            categoryDir,categoryItem->{
                val newCategoryId = db.insert("Category",null,values)
                Uri.parse("content://$authority/book/$newCategoryId")
            }
            else ->null
        }
        uriReturn
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?)=dbHelper?.let {
        //删除数据
        val dp = it.writableDatabase
        val deleteRows = when(uriMatcher.match(uri)){
            bookDir->dp.delete("Book",selection,selectionArgs)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                dp.delete("Book","id = ?", arrayOf(bookId))
            }
            categoryDir->dp.delete("Category",selection,selectionArgs)
            categoryItem -> {
                val bookId = uri.pathSegments[1]
                dp.delete("Category","categoryId = ?", arrayOf(bookId))
            }
            else -> 0
        }
        deleteRows
    }?:0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ) = dbHelper?.let {
        //更新数据
        val db = it.writableDatabase
        val updatedRows = when(uriMatcher.match(uri)){
            bookDir -> db.update("Book",values,selection,selectionArgs)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.update("Book",values,"id = ?" , arrayOf(bookId))
            }
            categoryDir -> db.update("Category",values,selection,selectionArgs)
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.update("Category",values,"categoryId = ?" , arrayOf(categoryId))
            }
            else -> null
        }
        updatedRows
    }?:0
}