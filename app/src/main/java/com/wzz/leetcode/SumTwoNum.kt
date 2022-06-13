package com.wzz.leetcode

/**
 * @ClassName SumTwoNum
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/5/21 9:57
 * @Version 1.0
 */
class SumTwoNum {

    /**
     * 暴力破解
     */
    fun twoSum(nums:IntArray , target:Int):IntArray{
        for (index in nums.indices){
            for (index2 in index +1 until nums.size){
                if ((nums[index]+nums[index2] == target)){
                    return intArrayOf(index,index2)
                }
            }
        }
        return intArrayOf()
    }

    /**
     * HashMap
     */
    fun sumHashMap(nums: IntArray , target: Int):IntArray{
        val hashMap:HashMap<Int,Int> = HashMap()
        for (index in nums.indices){
            val minus = target - nums[index]
            if (hashMap.containsKey(minus)){
                return intArrayOf(hashMap[minus]!!,index)
            }else{
                hashMap[nums[index]] = index
            }
        }
        return intArrayOf()
    }
}