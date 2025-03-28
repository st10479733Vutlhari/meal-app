package vcmsa.ci.mealapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var timeEditText: EditText
    private lateinit var recommendationTxt: TextView
    private lateinit var mealButton: Button
    private lateinit var clearButton: Button
    private lateinit var exitButton: Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        timeEditText = findViewById(R.id.timeEditText)
        recommendationTxt = findViewById(R.id.recommendationTxt)
        mealButton = findViewById(R.id.mealButton)
        clearButton = findViewById(R.id.clearButton)
        exitButton = findViewById(R.id.exitButton)

       //lists of foods
        val morning = listOf(
            "Porridge with milk",
            "Pancakes with berry fruits and honey syrup",
            "Scrambled eggs with buttered bread",
            "Oats with milk",
            "Omelette",
            "Toasted bread with avocado,eggs and a cup of tea"
        )
        val afternoon = listOf(
            "Chicken cajun wrap",
            "Sheet pan crispy ramen",
            "Tofu nuggets dunk in ranch dressing",
            "French dip stuffed biscuits",
            "Smash burger with fries and a cold drink",
            "Tacos",
            "Beef stir fry",
            "Snacks(energy bar, muesli and yogurt, potato chips with dip sauce",
        )
        val evening = listOf(
            "Mac and cheese",
            "Creamy french onion pasta",
            "Thai beef salad",
            "Cottage pie",
            "Chicken alfredo",
            "Pap and beef stew",
            "Spicy beef with rice and sweetcorn",
            "Skillet lasagna",
            "Deserts(chocolate cake, malva pudding, vanilla ice-cream with cookies, milkshake)"
        )

        mealButton.setOnClickListener {
            val timeOfDay = timeEditText.text.toString().lowercase()
             if (timeOfDay == "morning") {
                 val selectedFood = morning.random()
                 recommendationTxt.text = "FOR A PLEASANT MORNING MEAL HOW ABOUT THIS: $selectedFood?"
                 recommendationTxt.visibility = View.VISIBLE
        }else if (timeOfDay == "afternoon") {
            val selectedFood = afternoon.random()
                 recommendationTxt.text = "FOR A PLEASANT AFTERNOON MEAL HOW ABOUT THIS: $selectedFood?"
                 recommendationTxt.visibility = View.VISIBLE
             }else if (timeOfDay == "evening") {
                 val selectedFood = evening.random()
                 recommendationTxt.text = "FOR A PLEASANT EVENING MEAL HOW ABOUT THIS: $selectedFood?"
                 recommendationTxt.visibility = View.VISIBLE
             }else {
                 recommendationTxt.text = "Please enter 'morning' or 'afternoon' or 'evening,"//prompts user to enter text
             }

        }
        clearButton.setOnClickListener {
            clear()
        }
        exitButton.setOnClickListener {
            exit()
        }

    }

    private fun clear() {
        timeEditText.text.clear()//clears edit text
    }

    private fun exit(){
        Toast.makeText(this,"Exiting...", Toast.LENGTH_SHORT).show()
        finish()//exists ongoing activity
    }


}

