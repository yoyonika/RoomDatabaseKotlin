package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.Room
import android.content.Context
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyListDatabaseManager (private val myListDao: MyListDao) {
//    fun getAll(): Maybe<MyList> {
//        return MyList
//    }

//    fun getList(context: Context): MyListDatabaseManager {
//
//    }
    fun insertAll(myList: MyList): Completable {
        return Completable.fromAction{myListDao.insertAll(myList)}
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) // <- required to have subscribe operations execute on UI thread

    }

    fun updateAll(myList: MyList): Completable {
        return Completable.fromAction{myListDao.updateAll(myList)}
                .subscribeOn(Schedulers.newThread())
    }

    fun deleteAll(myList: MyList): Completable {
        return Completable.fromAction{myListDao.deleteAll(myList)}
                .subscribeOn(Schedulers.newThread())

    }
}