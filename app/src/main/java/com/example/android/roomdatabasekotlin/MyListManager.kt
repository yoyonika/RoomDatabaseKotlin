package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(MyList::class), version = 1)
abstract class MyListManager : RoomDatabase() {
    abstract fun myListDao(): MyListDao
}