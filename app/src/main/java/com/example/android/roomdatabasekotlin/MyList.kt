package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "myList")
data class MyList(
        @PrimaryKey(autoGenerate = true) // <- cannot use (autoGenerate = true) on String primary keys
        var id: Int,
        @ColumnInfo(name = "myToDoList")
        var myToDoList: String

)