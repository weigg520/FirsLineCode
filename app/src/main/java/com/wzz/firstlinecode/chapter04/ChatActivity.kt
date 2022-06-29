package com.wzz.firstlinecode.chapter04

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.activity_chat.*
import kotlin.collections.ArrayList

class ChatActivity : BaseActivity(),View.OnClickListener{

    private val msgList:MutableList<Msg> = ArrayList()
    private lateinit var msgAdapter:MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        initMsg()
        initContentRv()
    }

    private fun initMsg() {
        msgList.add(Msg("你好，小明." , Msg.TYPE_RECEIVED))
        msgList.add(Msg("你好，你是那个？" , Msg.TYPE_SEND))
        msgList.add(Msg("我是汤姆，和你聊天很高兴！" , Msg.TYPE_RECEIVED))
    }

    private fun initContentRv(){
        msgAdapter = MsgAdapter(msgList)
        msgContent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = msgAdapter
        }
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.send ->{
                val content = inputText.text.toString()
                if (content.isNotEmpty()){
                    msgList.add(Msg(content,Msg.TYPE_SEND))
                    msgAdapter.notifyItemChanged(msgList.size -1)
                    msgContent.scrollToPosition(msgList.size -1)
                    inputText.setText("")
                }
            }
        }
    }
}