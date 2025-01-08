package com.akeel.kubtechpapers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pastPapers: CardView = findViewById(R.id.previous_year_question_papers)
        val syllabus: CardView = findViewById(R.id.syllabus)
        val result: CardView = findViewById(R.id.results)

        // Set an OnClickListener
        pastPapers.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, EngineeringBranchesActivity::class.java)
            startActivity(intent)
        }
        syllabus.setOnClickListener{
            val intent = Intent(this, SyllabusActivity::class.java)
            startActivity(intent)
        }

        // In an activity, for example when a button is clicked
        val button = findViewById<CardView>(R.id.study_material)
        button.setOnClickListener {
            Toast.makeText(this, "This Section Will be Live Soon", Toast.LENGTH_SHORT).show()
        }
        // Set an OnClickListener
        result.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)

        }

    }
}
