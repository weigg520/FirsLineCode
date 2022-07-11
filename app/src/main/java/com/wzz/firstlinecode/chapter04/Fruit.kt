package com.wzz.firstlinecode.chapter04

class Fruit(val name:String,val imageId:Int):Comparable<Fruit>{
    override fun compareTo(other: Fruit): Int {
        return when {
            name == other.name -> 0
            name.length > other.name.length -> 1
            else -> 0
        }
    }

}
