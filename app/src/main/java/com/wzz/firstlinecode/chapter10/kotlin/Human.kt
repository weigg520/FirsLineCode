package com.wzz.firstlinecode.chapter10.kotlin

/**
 * @ClassName Human
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 15:30
 * @Version 1.0
 */
open class Person(val name:String , val age:Int): Comparable<Person> {
    override fun compareTo(other: Person): Int =
        if (name == other.name &&  age == other.age){
            0
        }else{
            1
        }
}

class Student(name: String,age: Int):Person(name,age)
class Teacher(name: String,age: Int):Person(name, age)
class SimpleData<out T>(val data:T?){
    fun get():T?{
        return data
    }
}

fun handleSimpleData(data: SimpleData<Person>){
    val teacher = data.get()
}

fun <T> testM(data:MutableList<T>){

}

fun main() {
    val mL = arrayListOf<Person>()
    val student = Student("魏晨",20)
    val teacher = Teacher("魏晨老师",20)
    val data = SimpleData<Student>(student)
    handleSimpleData(data)
    val listP = mutableListOf<Person>()
    listP.add(student)
    listP.add(teacher)
    for (p in listP){
        println("p---> " + p.name)
    }
    testM(mL)
}