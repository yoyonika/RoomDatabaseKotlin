package com.example.android.roomdatabasekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var something: MyListDatabaseManager
    private lateinit var adapterMyList: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        something = MyListDatabaseManager(this)
        adapterMyList = MyListAdapter()
    }

    override fun onResume() {
        super.onResume()
        val addButton = findViewById<View>(R.id.add_button)
        val editText = findViewById<EditText>(R.id.edit_text_view)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapterMyList

        something.selectAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({list -> adapterMyList.addStuffs(list)})

        addButton.setOnClickListener {
            var list = editText.text.toString()
            // textView.text = list
            adapterMyList.addStuff(MyList(list))
            Observable.fromCallable<Any> { something.insertAll(MyList(myToDoList = list)) }
                    .subscribeOn(Schedulers.io())
                    .subscribe()
//
//            Observable.fromCallable<Any> { something.updateAll(MyList(myToDoList = list)) }
//                    .subscribeOn(Schedulers.io())
//                    .subscribe()


        }
    }
}