package com.example.android.roomdatabasekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var something: MyListDatabaseManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        something = MyListDatabaseManager(this)
    }

        override fun onResume() {
            super.onResume().apply {
                val addButton = findViewById<View>(R.id.add_button)
                val textView = findViewById<TextView>(R.id.room_textview)
                val editText = findViewById<EditText>(R.id.edit_text_view)

                addButton.setOnClickListener {
                    var list = editText.text.toString()
                    textView.text = list
                    something.insertAll(MyList(myToDoList = list, id = 5))
                            .subscribeOn(Schedulers.io())
//                    something.updateAll(MyList(myToDoList = list, id =5))
//                            .subscribeOn(Schedulers.io())
                }
            }
        }
            //save and load list on open the app with the above parameter that is hard coded, then work on loading list from the getSingle in Dao









// database.myListt().insertAll(list)
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(insert(event))
        }
//            }
        //var list = editText.text.toString()
        //textView.text = list


        //val list = MyList(myToDoList = "List", id = 5)
//            val list = MyList(myToDoList = "List", id = 28398)
////
//            database.myListDao().insertAll(list) // <- calling DAO directly on UI thread, instead use MyListDatabaseManager.java

