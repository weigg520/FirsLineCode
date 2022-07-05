package com.wzz.firstlinecode.chapter08.kotlin
import kotlin.reflect.KProperty

/**
 * @ClassName Entrust
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/29 15:21
 * @Version 1.0
 */
class MySet<T>(private val helperSet:HashSet<T>) :Set<T>{
    override val size: Int
        get() = helperSet.size
    override fun contains(element: T) = helperSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)

    override fun isEmpty() = helperSet.isEmpty()

    override fun iterator(): Iterator<T> = helperSet.iterator()
}

class MyBySet<T>(val helperSet: HashSet<T>):Set<T> by helperSet{
    //扩展
    fun helloWorld() = println("你好世界")
    //重构
    override fun isEmpty(): Boolean =false
}

class MyByClass{
    val p by Delegate()
}

class Delegate{

    var propValue: Any? = null

    operator fun getValue(myByClass: MyByClass, property: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(myClass: MyByClass, prop: KProperty<*>, value: Any?){
        propValue = value
    }

}

//自定义lazy
@Suppress("UNCHECKED_CAST")
class Later<T>(val block:()->T){
    var value:Any? = null
    operator fun getValue(any: Any? , prop: KProperty<*>):T{
        if (value == null){
            value = block
        }
        return value as T
    }

}

fun main() {
    val  myBySet = MyBySet<String>(HashSet())
}