package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //App home page
        val heading=findViewById<TextView>(R.id.app_heading)
        heading.text="Welcome to BMI app"
        val name = findViewById<EditText>(R.id.user_name)
        val user_age = findViewById<EditText>(R.id.user_age)
        val genderGroup=findViewById<RadioGroup>(R.id.RadioGroup)
        val femalebtn=findViewById<RadioButton>(R.id.femalebtn)
        val malebtn=findViewById<RadioButton>(R.id.malebtn)


        val btnstart=findViewById<Button>(R.id.btnStart)
        btnstart.setOnClickListener {
            val nameText=name.text.toString().trim()
            val ageText=user_age.text.toString().trim()

            if(nameText.isEmpty()){
                Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(ageText.isEmpty()){
                Toast.makeText(this,"please enter age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val age=ageText.toIntOrNull()
            if(age==null){
                Toast.makeText(this,"enter valid age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender=when {
                femalebtn.isChecked-> "Female"
                malebtn.isChecked-> "Male"
                else -> "other"
            }
            var isMaleSelected = false
            var isFemaleSelected = false
            var selectedGender: String? = null
            femalebtn.setOnClickListener {
                isFemaleSelected= true
                isMaleSelected= false
                selectedGender="Female"

                femalebtn.isChecked=true
                malebtn.isChecked=false
            }
            malebtn.setOnClickListener {
                isFemaleSelected = false
                isMaleSelected = true
                selectedGender="Male"

                femalebtn.isChecked=false
                malebtn.isChecked=true
            }

            val intent = Intent(this, calculationActivity::class.java)
            intent.putExtra("name_key",nameText)
            intent.putExtra("age_key",age)
            intent.putExtra("gender_key",gender)
            startActivity(intent)


        }

    }



}

