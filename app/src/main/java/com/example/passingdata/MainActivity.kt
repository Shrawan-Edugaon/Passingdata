package com.example.passingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)
        val gender = findViewById<RadioGroup>(R.id.genderGroup)
        val submitButton = findViewById<Button>(R.id.submit)

//        submitButton.setOnClickListener{
//            val  intent = Intent(this, ProfileA::class.java )
//            intent.putExtra("userName",""+ name.text.toString())
//            intent.putExtra("userAge",""+ age.text.toString())
//            intent.putExtra("userGender",""+ name.text.toString())
//
////            startActivity(Intent(this, ProfileA::class.java ).putExtra("userName",""+ name.text.toString()))
//        }
        submitButton.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(name.text.toString())){
                name.setError("Enter Name..")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(age.text.toString())){
                age.setError("Enter Age..")
                return@OnClickListener
            }
            val intent = Intent(this,ProfileA::class.java).apply {
//                putExtra("name", "Kumar")
            }
            val bundle = Bundle()
            bundle.putString("userName",name.text.toString())
            bundle.putString("userAge",age.getText().toString())
            val gen_id = gender.getCheckedRadioButtonId()
            if (gen_id == -1){
                Toast.makeText(this@MainActivity,"Select Gender",Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }else{
                val radioButton = findViewById<RadioButton>(gen_id)
                val genValue = radioButton.text.toString()
                bundle.putString("userGender",genValue)
            }

            intent.putExtras(bundle)
//            intent.putExtra("name", "kumar")
//            Log.d("checkData", "sent" + bundle)

            startActivity(intent)
        })
    }
}