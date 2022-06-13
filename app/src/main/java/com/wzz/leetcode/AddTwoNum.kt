package com.wzz.leetcode

/**
 * @ClassName AddTwoNum
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/5/21 10:40
 * @Version 1.0
 */
class AddTwoNum {

    class ListNode(var `val`:Int){
        var next:ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        //让其引用可操作
        var c1 = l1
        var c2 = l2
        //新建一个存储和链表
        val root = ListNode(0)
        //可操作引用
        var cursor = root
        //进位标识
        var crray = 0
        while (c1!=null||c2!=null||crray!=0){
            //为null补0
            val l1Val = c1?.`val` ?: 0
            val l2Val = c2?.`val`?:0
            //求和
            val addVal = l1Val + l2Val + crray
            //是否需要进位
            crray = if(addVal>9) 1 else 0
            //创建和对象
            val addNode = ListNode(addVal%10)
            //加入链表
            cursor.next = addNode
            //引用移位
            cursor = addNode
            if (c1!=null)c1=c1.next
            if (c2!=null)c2 = c2.next
        }
        return root.next
    }

    /**
     * 递归
     */
    private fun add(l1: AddTwoNum.ListNode?, l2: ListNode?, bit:Int): ListNode? {
        if (l1==null&&l2==null&& bit ==0)return null
        var c1 = l1
        var c2 = l2
        var carry = bit
        if (c1!=null){
            carry += c1.`val`
            c1 = c1.next
        }
        if (c2!=null){
            carry += c2.`val`
            c2 = c2.next
        }
        val node = ListNode(carry%10)
        node.next = add(c1,c2,carry/10)
        return node
    }

}