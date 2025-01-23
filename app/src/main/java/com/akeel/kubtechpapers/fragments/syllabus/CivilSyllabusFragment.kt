package com.akeel.kubtechpapers.fragments.syllabus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.akeel.kubtechpapers.R
import com.akeel.kubtechpapers.WebViewActivity

class CivilSyllabusFragment : Fragment() {

    // URLs for each card
    private val urlUnit1 = "https://drive.google.com/file/d/11YEyeggIHl7g9TnSmsW4OUe67xUoXc2K/view?usp=drive_link"
    private val urlUnit2 = "https://drive.google.com/file/d/1ua5Y5jgHhkLVl5WQymRL5xGcE3PtRq76/view?usp=drive_link"
    private val urlUnit3 = "https://drive.google.com/file/d/1tNl53qM107KRuj4b06o9y7I6C3atw8ii/view?usp=drive_link"
    private val urlUnit4 = "https://drive.google.com/file/d/1bA3AEBGX9R8eMVYYGjvInLywE5aUk8k_/view?usp=drive_link"
    private val urlUnit5 = "https://drive.google.com/file/d/1jzzqpTD0TXI03UFzeB5-DYk_ROS9jK2t/view?usp=drive_link"
    private val urlUnit6 = "https://drive.google.com/file/d/1UOwLEgKp6n6sjglU2eBHc43vRVRtrbgL/view?usp=drive_link"
    private val urlUnit7 = "https://drive.google.com/file/d/1ujfnAsXVZfpD-sPGLut7hdEt7Wg6HMji/view?usp=drive_link"
    private val urlUnit8 = "https://drive.google.com/file/d/1JLqlg9ZWCPuuTIHMcZK0lCVT731S7LAf/view?usp=drive_link"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_civil_syllabus, container, false)

        // CardViews
        val cardUnit1 = view.findViewById<CardView>(R.id.card_sem1)
        val cardUnit2 = view.findViewById<CardView>(R.id.card_sem2)
        val cardUnit3 = view.findViewById<CardView>(R.id.card_sem3)
        val cardUnit4 = view.findViewById<CardView>(R.id.card_sem4)
        val cardUnit5 = view.findViewById<CardView>(R.id.card_sem5)
        val cardUnit6 = view.findViewById<CardView>(R.id.card_sem6)
        val cardUnit7 = view.findViewById<CardView>(R.id.card_sem7)
        val cardUnit8 = view.findViewById<CardView>(R.id.card_sem8)

        // Setting up click listeners for each card
        cardUnit1.setOnClickListener { openWebView(urlUnit1) }
        cardUnit2.setOnClickListener { openWebView(urlUnit2) }
        cardUnit3.setOnClickListener { openWebView(urlUnit3) }
        cardUnit4.setOnClickListener { openWebView(urlUnit4) }
        cardUnit5.setOnClickListener { openWebView(urlUnit5) }
        cardUnit6.setOnClickListener { openWebView(urlUnit6) }
        cardUnit7.setOnClickListener { openWebView(urlUnit7) }
        cardUnit8.setOnClickListener { openWebView(urlUnit8) }

        return view
    }

    // Function to open WebViewActivity
    private fun openWebView(url: String) {
        val intent = Intent(activity, WebViewActivity::class.java)
        intent.putExtra("URL", url) // Passing the URL to WebViewActivity
        startActivity(intent)
    }
}
