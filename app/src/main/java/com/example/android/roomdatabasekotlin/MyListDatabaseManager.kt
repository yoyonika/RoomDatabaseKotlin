package com.example.android.roomdatabasekotlin

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers

class MyListDatabaseManager (private val myListDao: MyListDao) {

    fun getAll(): Maybe<MyList> {
        return getAll()
    }

    fun insertAll(myList: MyList): Completable {
        return Completable.fromAction{myListDao.insertAll(myList)}
                .subscribeOn(Schedulers.newThread())

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