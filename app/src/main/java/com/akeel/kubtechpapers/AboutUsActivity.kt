package com.akeel.kubtechpapers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        // Social Media Links
        val linkedin = findViewById<ImageView>(R.id.linkedin_link)
        val github = findViewById<ImageView>(R.id.github_link)

        linkedin.setOnClickListener {
            openUrl("https://www.linkedin.com/in/akeel-shafi")
        }

        github.setOnClickListener {
            openUrl("https://github.com/akeelshafi")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
