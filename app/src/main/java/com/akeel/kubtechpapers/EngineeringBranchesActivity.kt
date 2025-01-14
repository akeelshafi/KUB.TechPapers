package com.akeel.kubtechpapers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.akeel.kubtechpapers.fragments.CivilEngineeringFragment
import com.akeel.kubtechpapers.fragments.ComputerEngineeringFragment
import com.akeel.kubtechpapers.fragments.ElectricalEngineeringFragment
import com.akeel.kubtechpapers.fragments.ElectronicsEngineeringFragment
import com.akeel.kubtechpapers.fragments.MechanicalEngineeringFragment

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
            navigateToFragment(ComputerEngineeringFragment())
        }

        civilCard.setOnClickListener {
            navigateToFragment(CivilEngineeringFragment()) // You will create this fragment
        }

        mechanicalCard.setOnClickListener {
            navigateToFragment(MechanicalEngineeringFragment()) // You will create this fragment
        }

        electricalCard.setOnClickListener {
            navigateToFragment(ElectricalEngineeringFragment()) // You will create this fragment
        }

        electronicsCard.setOnClickListener {
            navigateToFragment(ElectronicsEngineeringFragment()) // You will create this fragment
        }
    }

    // Function to navigate to the selected fragment
    private fun navigateToFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)  // Replace the content of the frame with the fragment
        transaction.addToBackStack(null)  // Add the transaction to back stack
        transaction.commit()  // Commit the transaction
    }
}
