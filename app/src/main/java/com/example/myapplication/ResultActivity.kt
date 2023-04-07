package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val loveScoreTextView = findViewById<TextView>(R.id.loveScoreTextView)

        val name1 = intent.getStringExtra("name1")
        val name2 = intent.getStringExtra("name2")
        val loveScore = intent.getIntExtra("loveScore", 0)

        loveScoreTextView.text = "$name1 and $name2 have a love score of $loveScore%"
    }
}
