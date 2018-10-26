package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.*

@Dao
interface MyListDao {

    @Query("SELECT * FROM MyList")
    fun getAll(): List<MyList>

    @Insert
    fun insertAll(myList: MyList)

    @Update
    fun updateAll(myList: MyList)

    @Delete
    fun deleteAll(myList: MyList)

}