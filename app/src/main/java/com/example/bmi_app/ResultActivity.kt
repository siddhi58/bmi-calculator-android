package com.example.bmi_app

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.ranges.contains

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Result =findViewById<TextView>(R.id.textView2)
        val nameTextview= findViewById<TextView>(R.id.nameTextview)
        val ageTextview=findViewById<TextView>(R.id.ageTextview)
        val guidanceTextview=findViewById<TextView>(R.id.textView5)
        val profie_img=findViewById<ImageView>(R.id.profile_img)


        val BMI=intent.getFloatExtra("Result", (-1.0).toFloat())
        val name=intent.getStringExtra("name_key")
        val age=intent.getIntExtra("age_key",0)
        val gender=intent.getStringExtra("gender_key") ?: "Not specified"


        when(gender){
            "Female"-> profie_img.setImageResource(R.drawable.female)
            "Male" -> profie_img.setImageResource(R.drawable.male)
        }
        nameTextview.text=name
        ageTextview.text="Age=$age"

        val category = when{
            BMI < 18.5 -> "Your BMI shows that you are Underweight"
            BMI in 18.5..24.9 -> "Your BMI Shows that You are at a Normal weight"
            BMI in 25.0..29.9 -> "Your BMI Shows that You are Over weight"
            BMI >= 30.0 -> "Your BMI Shows obesity"
            else->"Invalid input please try again"
        }
        Result.text= "BMI:%.2f \n$category".format(BMI)

            if(BMI < 18.5) {
                if (gender == "Female") {
                    guidanceTextview.text = """
                          This is guidance for you 
                          Morning:
                          1 glass milk or almond milk
                          1 boiled egg or 50g paneer
                          1 small banana
                          Mid-Morning Snack:
                          Handful of walnuts or soaked almonds
                          1 cup yogurt

                          Lunch:
                          100–120g grilled chicken or chickpeas/beans
                          1 cup cooked rice or 1–2 chapatis
                          1 bowl vegetable salad

                          Evening Snack:
                          Smoothie: milk + oats + fruits (apple or banana)

                          Dinner:
                          100g fish or paneer/tofu
                          1–2 chapatis
                          Steamed vegetables

                          Workout:
                          Light strength training 3x per week (bodyweight squats, lunges, yoga)
                          10–15 min brisk walk
                          """.trimIndent()
                } else {
                    guidanceTextview.text = """
                       Morning:
                       1 glass milk with 1 banana
                       2 boiled eggs
                       1 slice whole wheat bread with peanut butter

                       Mid-Morning Snack:
                       Handful of almonds or cashews
                       1 cup yogurt

                       Lunch:
                       150g grilled chicken or paneer
                       1 cup cooked rice or 2 chapatis
                       1 bowl mixed vegetables

                       Evening Snack:
                       Protein smoothie (milk + banana + oats)

                       Dinner:
                       150g fish or tofu
                       2 chapatis
                       Salad (carrot, cucumber, tomato)
                       1 glass milk

                       Workout:
                       Strength training 4x per week (push-ups, squats, dumbbell exercises)
                       15–20 min light cardio
                       """.trimIndent()
                }
            }

                 if(BMI in 18.5..24.9){
                    if(gender=="Female"){
                        guidanceTextview.text="""  
                            This is your guidance for maintaining weight 
                            Morning:
                            Oats porridge with milk and fruits
                            1 boiled egg (male) or 1 slice paneer (female)

                            Snack:
                            Fruits + nuts

                            Lunch:
                            100–150g protein (chicken/fish/paneer/beans)
                            1–2 chapatis or 1 cup rice
                            1 bowl salad

                            Evening:
                            Smoothie or fruit + yogurt

                            Dinner:
                            Protein source (chicken/fish/tofu/paneer)
                            1–2 chapatis
                            Vegetables
                            1 glass milk

                            Workout:
                            Cardio 20–30 min daily
                            Light strength exercises 3x per week
                        """.trimIndent()
                    }else{
                        guidanceTextview.text="""  
                            This is your guidance for maintaining weight 
                            Morning:
                            Oats porridge with milk and fruits
                            1 boiled egg (male) or 1 slice paneer (female)

                            Snack:
                            Fruits + nuts

                            Lunch:
                            100–150g protein (chicken/fish/paneer/beans)
                            1–2 chapatis or 1 cup rice
                            1 bowl salad

                            Evening:
                            Smoothie or fruit + yogurt

                            Dinner:
                            Protein source (chicken/fish/tofu/paneer)
                            1–2 chapatis
                            Vegetables
                            1 glass milk

                            Workout:
                            Cardio 20–30 min daily
                            Light strength exercises 3x per week
                        """.trimIndent()
                    }
                }

                if(BMI in 25.0..29.9){
                    if(gender=="Female"){
                        guidanceTextview.text=""" 
                             This is your guidance for getting perfect weight
                             Morning:
                             Green tea or black coffee
                             1 boiled egg or 50g paneer
                             1 slice whole wheat toast

                             Snack:
                             1 fruit

                             Lunch:
                             100g chicken / tofu / beans
                             1 chapati
                             Large salad bowl
                             
                             Evening:
                             Herbal tea or smoothie (unsweetened)

                             Dinner:
                             Protein + vegetables
                             Avoid rice or limit portion

                             Workout:
                             25–35 min cardio
                             Yoga or strength exercises 3x per week
                        """.trimIndent()
                    }else{
                        guidanceTextview.text=""" 
                            This is your guidance 
                            Morning:
                            1 cup green tea or black coffee
                            2 boiled eggs
                            1 slice whole wheat bread
                            
                            Snack:
                            1 apple or orange
                            
                            Lunch:
                            120g grilled chicken or tofu
                            1 chapati
                            Large bowl vegetables

                            Evening:
                            Herbal tea
                            Handful of nuts

                            Dinner:
                            100g fish or paneer
                            1 chapati
                            Steamed vegetables

                            Workout:
                            30–40 min brisk walk or cardio daily
                            Strength training 3x per week
                        """.trimIndent()
                    }
                }
                if(BMI >= 30.0){
                    if(gender=="Female"){
                        guidanceTextview.text=""" 
                            This is your Guidance 
                            Morning:
                            Warm water with lemon
                            1 boiled egg or 50g paneer
                            1 slice toast

                            Snack:
                            1 fruit or cucumber sticks

                            Lunch:
                            80–100g chicken / tofu / beans
                            1 chapati
                            Large salad bowl

                            Evening:
                            Green tea or herbal tea

                            Dinner:
                            Protein + steamed vegetables
                            Avoid rice and fried items

                            Workout:
                            30–40 min cardio
                            Strength training 3x per week
                        """.trimIndent()
                    }else{
                        guidanceTextview.text=""" 
                            This is your Guidance 
                            Morning:
                            Warm water with lemon
                            1 boiled egg
                            1 slice whole wheat toast

                            Snack:
                            1 cucumber or carrot sticks

                            Lunch:
                            100g grilled chicken or tofu
                            1 chapati
                            Large bowl of vegetables
                            
                            Evening:
                            Green tea

                            Dinner:
                            Protein + salad
                            Avoid rice and fried food

                            Workout:
                            40 min brisk walk / treadmill daily
                            Strength training 3x per week
                            Avoid long periods of sitting
                        """.trimIndent()
                    }
                }

        }



    }
