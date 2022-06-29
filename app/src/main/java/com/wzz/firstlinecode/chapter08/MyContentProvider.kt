package com.wzz.firstlinecode.chapter08

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

/**
 * @ClassName MyContentProvider
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/28 17:10
 * @Version 1.0
 */
class MyContentProvider :ContentProvider(){

    private val packageName = "com.wzz.firstlinecode.provider"
    private val table1Dir = 0
    private val table1Item = 1
    private val table2Dir = 2
    private val table2Item = 3

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI(packageName,"table1",table1Dir)
        uriMatcher.addURI(packageName,"table1/#",table1Item)
        uriMatcher.addURI(packageName,"table2",table2Dir)
        uriMatcher.addURI(packageName,"table2/#",table2Item)
    }

    override fun onCreate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        when(uriMatcher.match(uri)){
            table1Dir->{
                //return
                return null
            }
        }
        return null
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}