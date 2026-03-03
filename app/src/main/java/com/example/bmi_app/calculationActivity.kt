package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class calculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Calculation page
        //Declaring UI Elements
        val weight=findViewById<EditText>(R.id.weight_edittext)
        val height=findViewById<EditText>(R.id.height_edittext)
        val btn=findViewById<Button>(R.id.cal_btn)



        val name=intent.getStringExtra("name_key")
        val age=intent.getIntExtra("age_key",0)
        val gender=intent.getStringExtra("gender_key")



        //calculating BMI
        btn.setOnClickListener {
            //converting into string
            val weightText=weight.text.toString()
            val heightText=height.text.toString()

            //checking if its empty or not
            if(weightText.isEmpty()){
                Toast.makeText(this,"please enter weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(heightText.isEmpty()){
                Toast.makeText(this,"Please enter height", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //converting into float
            val weight=weightText.toFloat()
            val height=heightText.toFloat()


            //BMI formulae
            val heightInMeter=height*0.3048f
            val BMI=weight / (heightInMeter * heightInMeter)


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("Result",BMI.toFloat())
            intent.putExtra("name_key",name)
            intent.putExtra("age_key",age)
            intent.putExtra("gender_key",gender)
            startActivity(intent)

        }
    }
}