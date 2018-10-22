package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "myList")
data class MyList(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "myToDoList")
        var myToDoList: String

)