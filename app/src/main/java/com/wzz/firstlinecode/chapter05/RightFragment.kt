package com.wzz.firstlinecode.chapter05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wzz.firstlinecode.R

/**
 * @ClassName LiftFragment
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/24 13:41
 * @Version 1.0
 */
class RightFragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.right_fragment,container,false)
    }
}