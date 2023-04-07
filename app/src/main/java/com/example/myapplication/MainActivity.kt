package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name1EditText = findViewById<EditText>(R.id.name1EditText)
        val name2EditText = findViewById<EditText>(R.id.name2EditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val name1 = name1EditText.text.toString().trim()
            val name2 = name2EditText.text.toString().trim()

            if (name1.isNotEmpty() && name2.isNotEmpty()) {
                val timer = object : CountDownTimer(3000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        // You can add code here to update the UI during the countdown
                    }

                    override fun onFinish() {
                        val loveCalculation = LoveCalculation()
                        val loveScore = loveCalculation.calculateLove(name1, name2)
                        saveLoveScore(name1, name2, loveScore)

                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra("name1", name1)
                        intent.putExtra("name2", name2)
                        intent.putExtra("loveScore", loveScore)
                        startActivity(intent)
                    }
                }
                timer.start()
            } else {
                Toast.makeText(this, "Please enter both names", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveLoveScore(name1: String, name2: String, score: Int) {
        val sharedPreferences = getSharedPreferences("LoveScores", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("$name1-$name2", score)
        editor.apply()
    }
}
