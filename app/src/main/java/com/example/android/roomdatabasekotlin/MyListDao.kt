package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.*
import io.reactivex.Maybe

@Dao
interface MyListDao {

    @Query("SELECT * FROM MyList")
    fun getAll(): List<MyList> //create getsingle and get list passing id as a field

    @Insert
    fun insertAll(myList: MyList)

    @Update
    fun updateAll(myList: MyList)

    @Delete
    fun deleteAll(myList: MyList)

//    @Query("SELECT * FROM myList WHERE listId = :id")
//    fun getSingle(): List<MyList>

}