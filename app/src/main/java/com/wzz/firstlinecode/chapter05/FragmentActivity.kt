package com.wzz.firstlinecode.chapter05

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import kotlinx.android.synthetic.main.right_fragment.*

class FragmentActivity : BaseActivity() {

    val anotherRightFragment:AnotherRightFragment = AnotherRightFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportActionBar?.hide()
        add.setOnClickListener {
            replaceFragment(anotherRightFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.another_fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}