package com.example.passingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ProfileA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle = intent.extras
        val uname = findViewById<TextView>(R.id.nameValue)
        val uage = findViewById<TextView>(R.id.ageValue)
        val ugender = findViewById<TextView>(R.id.genderValue)

        uname.setText(bundle!!.getCharSequence("userName"))
        uage.setText(bundle!!.getCharSequence("userAge"))
        ugender.setText(bundle!!.getCharSequence("userGender"))

        val back = findViewById<Button>(R.id.backButton) as Button
        back.setOnClickListener {
            val intent = Intent(this@ProfileA,MainActivity::class.java)
            startActivity(intent)
        }

//       Toast.makeText(this, uname + uage + ugender, Toast.LENGTH_SHORT).show()
    }
}