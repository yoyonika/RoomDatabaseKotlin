package com.example.android.roomdatabasekotlin

import android.arch.persistence.room.Room
import android.content.Context
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toSingle
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

class MyListDatabaseManager(context: Context) {

    private lateinit var list: MyListManager

    init {
        getList(context)
        list = Room.databaseBuilder(
                context,
                MyListManager::class.java,
                "myToDoList")
                .build()
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

    fun insert(myList: MyList) : Single<Unit>{
        return Single.fromCallable(Callable {
            list.myListDao().insertAll(myList)
        })
    }
    fun insertAll(myList: MyList): Completable {
        return Completable.fromAction { list.myListDao().insertAll(myList) }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()) // <- required to have subscribe operations execute on UI thread

    }

    fun updateAll(myList: MyList): Completable {
        return Completable.fromAction { list.myListDao().updateAll(myList) }
                .subscribeOn(Schedulers.newThread())
    }

    fun deleteAll(myList: MyList): Completable {
        return Completable.fromAction { list.myListDao().deleteAll(myList) }
                .subscribeOn(Schedulers.newThread())

    }

    fun selectAll(): Single<List<MyList>> {
        return list.myListDao().getAll()
                .subscribeOn(Schedulers.newThread())
                .toSingle()
    }
}