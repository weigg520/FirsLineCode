package com.wzz.firstlinecode.chapter12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wzz.firstlinecode.R
import kotlinx.android.synthetic.main.activity_fruit_activity.*

class FruitActivity : AppCompatActivity() {

    companion object{
        const val F_NAME = "f_name"
        const val F_IMAGE = "f_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_activity)
        val fName = intent.getStringExtra(F_NAME)?:""
        val fImage = intent.getIntExtra(F_IMAGE,0)
        setSupportActionBar(f_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        f_coll.title = fName
        f_image.setImageResource(fImage)
        f_fb.setImageResource(fImage)
        f_tv.text = fName.repeat(5000)
    }
}