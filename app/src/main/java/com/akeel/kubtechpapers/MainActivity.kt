package com.akeel.kubtechpapers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the custom toolbar
        val toolbar: Toolbar = findViewById(R.id.custom_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "KU B.Tech Papers"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pastPapers: CardView = findViewById(R.id.previous_year_question_papers)
        val syllabus: CardView = findViewById(R.id.syllabus)
        val result: CardView = findViewById(R.id.results)
        val aboutUs: CardView = findViewById(R.id.aboutus)

        // Set an OnClickListener
        pastPapers.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, EngineeringBranchesActivity::class.java)
            startActivity(intent)
        }
        syllabus.setOnClickListener {
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
        // Set an OnClickListener
        aboutUs.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)

        }

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

            /*  R.id.privacy_policy -> {
                  // Open the Privacy Policy in a browser
                  val intent =
                      Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/privacy-policy"))
                  startActivity(intent)
                  true
              }*/

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