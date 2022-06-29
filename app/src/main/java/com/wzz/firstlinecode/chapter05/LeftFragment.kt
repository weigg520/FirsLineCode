package com.wzz.firstlinecode.chapter05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wzz.firstlinecode.R
import kotlinx.android.synthetic.main.another_frgament.*
import kotlinx.android.synthetic.main.left_fragment.*

/**
 * @ClassName LiftFragment
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/24 13:41
 * @Version 1.0
 */
class LeftFragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.left_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_first?.setOnClickListener {
            if (activity!=null){
                val aF = activity as FragmentActivity
                val anotherRightFragment = aF.anotherRightFragment
                //必须两个都绑定在Activity上了才能通信
                if (anotherRightFragment.activity!=null){
                    anotherRightFragment.another_fragment_tv.text = "长沙"
                }
            }
        }
    }
}