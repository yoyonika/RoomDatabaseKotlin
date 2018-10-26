package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "myList")
data class MyList(
       @PrimaryKey()
//        @ColumnInfo (name = "listId")
//        var id: Int,
        @ColumnInfo(name = "myToDoListColumn")
        var myToDoList: String

)