package com.akeel.kubtechpapers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.akeel.kubtechpapers.fragments.syllabus.CivilSyllabusFragment
import com.akeel.kubtechpapers.fragments.syllabus.ComputerSyllabusFragment
import com.akeel.kubtechpapers.fragments.syllabus.ElectricalSyllabusFragment
import com.akeel.kubtechpapers.fragments.syllabus.ElectronicsSyllabusFragment
import com.akeel.kubtechpapers.fragments.syllabus.MechanicalSyllabusFragment

class SyllabusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)

        // Set up the custom toolbar
        val toolbar: Toolbar = findViewById(R.id.custom_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "KU B.Tech Papers"

        // Find CardViews for each branch
        val computerCard = findViewById<CardView>(R.id.syllabus_computer_engineering)
        val civilCard = findViewById<CardView>(R.id.syllabus_civil_engineering)
        val mechanicalCard = findViewById<CardView>(R.id.syllabus_mechanical_engineering)
        val electricalCard = findViewById<CardView>(R.id.syllabus_electrical_engineering)
        val electronicsCard = findViewById<CardView>(R.id.syllabus_electronics_engineering)

        // Set click listeners for navigation
        computerCard.setOnClickListener {
            navigateToFragment(ComputerSyllabusFragment())
        }

        civilCard.setOnClickListener {
            navigateToFragment(CivilSyllabusFragment()) // You will create this fragment
        }

        mechanicalCard.setOnClickListener {
            navigateToFragment(MechanicalSyllabusFragment()) // You will create this fragment
        }

        electricalCard.setOnClickListener {
            navigateToFragment(ElectricalSyllabusFragment()) // You will create this fragment
        }

        electronicsCard.setOnClickListener {
            navigateToFragment(ElectronicsSyllabusFragment()) // You will create this fragment
        }
    }

    // Function to navigate to the selected fragment
    private fun navigateToFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            fragment
        )  // Replace the content of the frame with the fragment
        transaction.addToBackStack(null)  // Add the transaction to back stack
        transaction.commit()  // Commit the transaction
    }

    // Inflate the menu (this will be used to add items to the toolbar)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar, menu)
        return true
    }

    // Handle item clicks in the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_us -> {
                // Show "About Us" details in a dialog or a new activity
                val intent = Intent(this, AboutUsActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.privacy_policy -> {
                // Open the Privacy Policy in a browser
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/privacy-policy"))
                startActivity(intent)
                true
            }

            R.id.check_for_updates -> {
                // Check for app updates in the Play Store
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.example.app")
                )
                startActivity(intent)
                true
            }

            R.id.share_app -> {
                // Share the app with others
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                val shareText =
                    "Check out this app: https://play.google.com/store/apps/details?id=com.example.app"
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                startActivity(Intent.createChooser(shareIntent, "Share App"))
                true
            }

            R.id.rate_us -> {
                // Open the Play Store page for the app to rate it
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.example.app")
                )
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}