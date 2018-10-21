package com.example.android.roomdatabasekotlin

import android.app.usage.UsageEvents
import android.arch.lifecycle.Lifecycle
import android.arch.persistence.room.Room
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.SyncStateContract.Helpers.insert
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    //private lateinit var something:MyListManager
    val database = Room.databaseBuilder(context, MyListManager::class.java, "my database").build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //something = MyListManager.getList(applicationContext)

        val addButton = findViewById<View>(R.id.add_button)
        val textView = findViewById<TextView>(R.id.room_textview)
        val editText = findViewById<EditText>(R.id.edit_text_view)

        addButton.setOnClickListener {
            val list = MyList(myToDoList = "List", id = 5)
            //something = MyListManager.getList(applicationContext)
            fun insert (event: ContactsContract.CommonDataKinds.Event) : Completable = Completable.fromCallable {
                database.myListDao().insertAll(list)

             database.myListt().insertAll(list)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(insert(event))
            }
//            }
            //var list = editText.text.toString()
            //textView.text = list
             //val list = MyList(myToDoList = "List", id = 5)
            //val list = MyList(myToDoList = "List", id = 28398)
//
            //database.myListDao().insertAll(list) // <- calling DAO directly on UI thread, instead use MyListDatabaseManager.java
        }
    }
}
