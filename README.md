BMI Calculator 🩺

Enter your name, age, gender, weight and height — and get your BMI result with a full personalized guidance plan based 
on your category. Not just a number. Actually useful.

--------------------------------------------------------------------------------------------------------------------------------
📸 Screenshots



----------------------------------------------------------------------------------------------------------------------------------
✦ Features


Personalized welcome — enter your name, age and gender before starting
Gender-aware avatar on the result screen (male/female character)
Height input via a smooth slider — no typing needed
BMI result with plain-English verdict (Underweight / Normal / Overweight / Obese)
Full personalized guidance per category — Morning, Snack, Lunch and workout more
Meal suggestions are gender-specific (e.g. egg for male, paneer for female)
Input validation — won't let you proceed with empty fields


-----------------------------------------------------------------------------------------------------------------------------------
🛠 Tech

Kotlin · XML · RadioButtons · SeekBar (Slider) · Intents · CardView · Android Studio

------------------------------------------------------------------------------------------------------------------------------------
▶ Run it

bashgit clone https://github.com/siddhi58/bmi-calculator-android.git

Open in Android Studio → let Gradle sync → hit Run. Needs API 21+.

-------------------------------------------------------------------------------------------------------------------------------------
💡 What I learned building this

This was my first Android project and it ended up being much more than I originally planned.

It started simple — just calculate BMI and show the result. But then I thought, what's the point of knowing your 
BMI if the app doesn't tell you what to do about it? So I added a full  guidance section for each category, 
and made it gender-specific on top of that. That's when it stopped feeling like a practice project and started feeling like something 
real.

Building the three-screen flow was where I got comfortable with Intents — passing name, age, and gender from screen one 
all the way through to the result screen. The gender avatar was a small touch but it made the result feel personal, which I liked.

Getting it to display a live decimal value as the user drags it took some figuring out, but it felt much better than just typing 
a number.

-------------------------------------------------------------------------------------------------------------------------------------
🔧 What I'd improve next


-Add a BMI history tracker so users can see progress over time
-Metric and imperial unit toggle
-Animated result reveal

---------------------------------------------------------------------------------------------------------------------------------------

Siddhi Bidkar · LinkedIn · GitHub · siddhibidkar04@gmail.com
