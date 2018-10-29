package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.*
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface MyListDao {

    @Query("SELECT * FROM MyList")
    fun getAll(): Maybe<List<MyList>>

    @Insert
    fun insertAll(myList: MyList)

    @Update
    fun updateAll(myList: MyList)

    @Query ("DELETE FROM MyList")
    fun deleteAll()

}