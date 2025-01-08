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
        val urlUnit1 = "https://example.com/unit1"
        val urlUnit2 = "https://example.com/unit2"
        val urlUnit3 = "https://example.com/unit3"
        val urlUnit4 = "https://example.com/unit4"
        val urlUnit5 = "https://example.com/unit5"

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
