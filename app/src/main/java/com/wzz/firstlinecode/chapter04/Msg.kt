package com.wzz.firstlinecode.chapter04

/**
 * @ClassName Msg
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/20 13:47
 * @Version 1.0
 */
class Msg(val content:String,val type:Int) {
    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}