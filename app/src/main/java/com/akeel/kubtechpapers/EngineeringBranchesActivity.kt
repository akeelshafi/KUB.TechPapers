package com.akeel.kubtechpapers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class EngineeringBranchesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engineering_branches)

        // Find CardViews for each branch
        val computerCard = findViewById<CardView>(R.id.computer_science)
        val civilCard = findViewById<CardView>(R.id.civil_engineering)
        val mechanicalCard = findViewById<CardView>(R.id.mechanical_engineering)
        val electricalCard = findViewById<CardView>(R.id.electrical_engineering)
        val electronicsCard = findViewById<CardView>(R.id.electronics_engineering)

        // Set click listeners for navigation
        computerCard.setOnClickListener {
            navigateToSemesterActivity("Computer Engineering")
        }

        civilCard.setOnClickListener {
            navigateToSemesterActivity("Civil Engineering")
        }

        mechanicalCard.setOnClickListener {
            navigateToSemesterActivity("Mechanical Engineering")
        }

        electricalCard.setOnClickListener {
            navigateToSemesterActivity("Electrical Engineering")
        }

        electronicsCard.setOnClickListener {
            navigateToSemesterActivity("Electronics Engineering")
        }
    }

    private fun navigateToSemesterActivity(branchName: String) {
        val intent = Intent(this, SemesterActivity::class.java)
        intent.putExtra("branch", branchName)
        startActivity(intent)
    }
}
