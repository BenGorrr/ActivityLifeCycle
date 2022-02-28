package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.mymodels.MyData

class MainActivity : AppCompatActivity() {

    private lateinit var myValue : MyData
    //var myValue : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "OnCreate")

        myValue = ViewModelProvider(this).get(MyData::class.java)

        var btn: Button = findViewById(R.id.btnOk)
        var tvName : TextView = findViewById(R.id.tvName)
        var tvAge : TextView = findViewById(R.id.tvAge)

        myValue.name.observe(this, Observer {
            newName -> tvName.text = newName
        })
        myValue.age.observe(this, Observer {
            newAge -> tvAge.text = newAge.toString()
        })

//        if (savedInstanceState != null) {
//            tv.text = savedInstanceState.getString("value").toString()
//        }
        if (myValue.name.value != "") {
            //display()
        }

        btn.setOnClickListener {
            myValue.name.value = "John"
            myValue.age.value = 21
            //display()
        }
    }

    fun display() {
        var tv : TextView = findViewById(R.id.tvName)
        tv.text = myValue.name.value
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        outState.putString("value", myValue)
//
//    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "OnDestroy")
    }
}