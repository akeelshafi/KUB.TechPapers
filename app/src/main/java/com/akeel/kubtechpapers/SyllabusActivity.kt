package com.akeel.kubtechpapers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SyllabusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)

        // CardViews
        val cardUnit1 = findViewById<CardView>(R.id.syllabus_computer_engineering)
        val cardUnit2 = findViewById<CardView>(R.id.syllabus_civil_engineering)
        val cardUnit3 = findViewById<CardView>(R.id.syllabus_mechanical_engineering)
        val cardUnit4 = findViewById<CardView>(R.id.syllabus_electrical_engineering)
        val cardUnit5 = findViewById<CardView>(R.id.syllabus_electronics_engineering)

        // URLs for each card
        val urlUnit1 = "https://drive.google.com/drive/folders/1C6oKSh4DLaM85NkmbZER_nuQkkJfPQ9C?usp=sharing"
        val urlUnit2 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        val urlUnit3 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        val urlUnit4 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        val urlUnit5 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"

        // Setting up click listeners
        cardUnit1.setOnClickListener { openWebView(urlUnit1) }
        cardUnit2.setOnClickListener { openWebView(urlUnit2) }
        cardUnit3.setOnClickListener { openWebView(urlUnit3) }
        cardUnit4.setOnClickListener { openWebView(urlUnit4) }
        cardUnit5.setOnClickListener { openWebView(urlUnit5) }
    }

    // Function to open WebViewActivity
    private fun openWebView(url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", url) // Passing the URL to WebViewActivity
        startActivity(intent)
    }
}
