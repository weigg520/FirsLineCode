package com.wzz.firstlinecode.chapter05.kotlin

/**
 * @ClassName String
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/25 11:48
 * @Version 1.0
 */
fun String.lettersCount():Int{
    var count =0
    for (char in this){
        if (char.isLetter()){
            if (char in 'a'..'z'){
                count++
            }
        }
    }
    return count
}

operator fun String.times(n:Int) = repeat(n)