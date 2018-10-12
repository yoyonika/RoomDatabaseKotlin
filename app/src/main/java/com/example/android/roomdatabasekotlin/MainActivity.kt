package com.example.android.roomdatabasekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var something:MyListManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        something = MyListManager.getList(applicationContext)

        val addButton = findViewById<View>(R.id.add_button)
        val textView = findViewById<TextView>(R.id.room_textview)
        val editText = findViewById<EditText>(R.id.edit_text_view)

        addButton.setOnClickListener {
//            var list = editText.text.toString()
//            textView.text = list
            val list = MyList(myToDoList = "List")
                something.myListDao().insertAll(list)

        }
    }


}
