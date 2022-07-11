package com.wzz.firstlinecode.chapter10.kotlin

/**
 * @ClassName Transformer
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 16:18
 * @Version 1.0
 */
interface Transformer<in T>{
    fun transformer(t : T):String
    fun transformer(name:String , age:Int): @UnsafeVariance T
}

fun main() {
    val trans = object :Transformer<Person>{
        override fun transformer(t: Person): String {
            return "${t.name}${t.age}"
        }

        override fun transformer(name: String, age: Int): Person {
            return Teacher(name,age)
        }
    }
    handleTransformer(trans)
}

fun  handleTransformer(transformer: Transformer<Student>){
    val student = Student("tom" , 10)
    val result = transformer.transformer(student)
    val result2 = transformer.transformer("魏晨",20)
}