package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(MyList::class), version = 1)
abstract class MyListManager : RoomDatabase() {
    abstract fun myListDao(): MyListDao
    abstract fun myListt():MyListDatabaseManager

    companion object {
        private var list: MyListManager? = null
        fun getList(context: Context): MyListManager {
            if (list == null) {
                list = Room.databaseBuilder(
                        context,
                        MyListManager::class.java,
                        "myToDoList")
                        .build()
            }
            return list as MyListManager
        }
    }
}