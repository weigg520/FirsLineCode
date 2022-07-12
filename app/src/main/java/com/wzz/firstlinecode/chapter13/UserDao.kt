package com.wzz.firstlinecode.chapter13

import androidx.room.*

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/12 16:26
 * @Version 1.0
 */
@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User):Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers():List<User>

    @Query("select * from User where age > :age")
    fun loadUsersOlderThan(age:Int):List<User>

    @Query("select * from User where id = :userId")
    fun loadUserById(userId:Long):User

    @Delete
    fun deleteUser(user: User)

    @Query("delete from User where name =:userId")
    fun deleteByUserId(userId:String):Int
}