package com.wzz.firstlinecode.chapter05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wzz.firstlinecode.R

/**
 * @ClassName AnotherRightFragment
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/24 14:05
 * @Version 1.0
 */
class AnotherRightFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.another_frgament,container,false)
    }
}