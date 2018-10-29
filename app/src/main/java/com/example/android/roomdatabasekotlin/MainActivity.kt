package com.example.android.roomdatabasekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var something: MyListDatabaseManager
    private lateinit var adapterMyList: MyListAdapter

    //should have everything to do with layout etc
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        something = MyListDatabaseManager(this)
        adapterMyList = MyListAdapter()
        val addButton = findViewById<View>(R.id.add_button)
        val editText = findViewById<EditText>(R.id.edit_text_view)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapterMyList

        something.selectAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({list -> adapterMyList.addStuffs(list)})

        //OnClickListener
        addButton.setOnClickListener {
            val list = editText.text.toString()
            //adds text to the adapter
            adapterMyList.addStuff(MyList(list))
            //inserts to list
            something.insert(MyList(list))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
        }

        delete_button.setOnClickListener {
            something.delete(MyList((adapterMyList.deleteStuffs().toString())))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
        }
    }
}

//on resume should have all the network calls etc