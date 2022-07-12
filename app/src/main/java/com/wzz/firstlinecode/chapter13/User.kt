package com.wzz.firstlinecode.chapter13

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @ClassName User
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/12 11:16
 * @Version 1.0
 */
@Entity
data class User(var name:String,var age:Int){

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}