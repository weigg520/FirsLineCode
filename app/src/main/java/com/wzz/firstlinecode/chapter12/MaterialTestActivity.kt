package com.wzz.firstlinecode.chapter12
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wzz.firstlinecode.R
import com.wzz.firstlinecode.chapter03.BaseActivity
import com.wzz.firstlinecode.chapter04.Fruit
import kotlinx.android.synthetic.main.activity_material_test.*

class MaterialTestActivity : BaseActivity() {

    private var fruitListData = mutableListOf(Fruit("香蕉",R.drawable.banana),
        Fruit("猕猴桃",R.drawable.kiwi_fruit),
        Fruit("榴莲",R.drawable.durian),
        Fruit("柠檬",R.drawable.lemon),
        Fruit("芒果",R.drawable.mango),
        Fruit("西瓜",R.drawable.watermelon),
        Fruit("梨子",R.drawable.pears))
    private val fData:ArrayList<Fruit> = ArrayList()

    override fun getContentViewId(): Int=R.layout.activity_material_test

    override fun initView() {
        initFruitsData()
        val adapter = FAdapter(this,fData)
        rv_material.layoutManager = GridLayoutManager(this,4)
        rv_material.adapter = adapter
    }

    private fun initFruitsData(){
        fData.clear()
        repeat(50){
            val index = (0 until fruitListData.size).random()
            fData.add(fruitListData[index])
        }
    }
}