package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
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
        var tv : TextView = findViewById(R.id.textView)

//        if (savedInstanceState != null) {
//            tv.text = savedInstanceState.getString("value").toString()
//        }
        if (myValue.name != "") {
            tv.text = myValue.name
        }

        btn.setOnClickListener {
            myValue.name = "John"
            myValue.age = 21
            tv.text = myValue.name
        }
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