package com.wzz.firstlinecode.chapter04.kotlin

import com.wzz.firstlinecode.chapter04.Msg
import com.wzz.firstlinecode.chapter04.MsgAdapter

/**
 * @ClassName LateInitKotlin
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/20 15:41
 * @Version 1.0
 */
class LateInitKotlin {

    /**
     * 延迟初始化
     */
    private lateinit var msgAdapter: MsgAdapter
    private lateinit var listMsg:MutableList<Msg>

    init {
        if (!::listMsg.isLateinit){
            listMsg = ArrayList()
            listMsg.add(Msg("延迟初始化",Msg.TYPE_RECEIVED))
        }
        if (!::msgAdapter.isLateinit){
            msgAdapter = MsgAdapter(listMsg)
        }
    }


}