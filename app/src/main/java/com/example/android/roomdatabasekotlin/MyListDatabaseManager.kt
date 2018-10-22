package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.Room
import android.content.Context
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyListDatabaseManager(context: Context) {

    init {
        getList(context);
    }

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

    fun insertAll(myList: MyList): Completable {
        return Completable.fromAction { list?.myListDao()?.insertAll(myList) }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) // <- required to have subscribe operations execute on UI thread

    }

    fun updateAll(myList: MyList): Completable {
        return Completable.fromAction { list?.myListDao()?.updateAll(myList) }
                .subscribeOn(Schedulers.newThread())
    }

    fun deleteAll(myList: MyList): Completable {
        return Completable.fromAction { list?.myListDao()?.deleteAll(myList) }
                .subscribeOn(Schedulers.newThread())

    }

}