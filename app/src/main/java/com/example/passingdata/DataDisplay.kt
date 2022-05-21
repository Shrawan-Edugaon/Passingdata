package com.example.passingdata

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DataDisplay :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.display)

        val uname = "shrawan" +intent.extras?.getString("userName")
        Toast.makeText(this, uname, Toast.LENGTH_SHORT).show()
    }
}