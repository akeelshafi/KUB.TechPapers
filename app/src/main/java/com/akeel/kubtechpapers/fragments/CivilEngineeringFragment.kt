package com.akeel.kubtechpapers.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.akeel.kubtechpapers.PaperDisplayActivity
import com.akeel.kubtechpapers.R


class CivilEngineeringFragment : Fragment() {

    // URLs for each card
    private val urlUnit1 = "https://drive.google.com/drive/folders/1CqFsKV3Z8GHrVnAR89Z259sVYN_rhpK6?usp=drive_link"
    private val urlUnit2 = "https://drive.google.com/drive/folders/1CuM9Y_ki4v1u4H0qe70Jf7M2SU2BVsID?usp=drive_link"
    private val urlUnit3 = "https://drive.google.com/drive/folders/1CvsNEGrsctakoZpsVfX0knNSQn8mIgKr?usp=drive_link"
    private val urlUnit4 = "https://drive.google.com/drive/folders/1CvuasJ3aleEo9cIkSXzCvkFRzbWTRG8e?usp=drive_link"
    private val urlUnit5 = "https://drive.google.com/drive/folders/1CxG-573lcwc-69jnXv_i2PXk3H8CAo7r?usp=drive_link"
    private val urlUnit6 = "https://drive.google.com/drive/folders/1D-7PaBM3Iyd7Hq4xp6IOEwfbe_TmI_Gw?usp=drive_link"
    private val urlUnit7 = "https://drive.google.com/drive/folders/1D2rBTMZ_tW2YTl_7OE7EuYWPeXOv5lvC?usp=drive_link"
    private val urlUnit8 = "https://drive.google.com/drive/folders/1D7puj22kHKA1UDswBkN_oh_uHJr_-5Wd?usp=drive_link"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_civil_engineering, container, false)
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
        val intent = Intent(activity, PaperDisplayActivity::class.java)
        intent.putExtra("URL", url) // Passing the URL to WebViewActivity
        startActivity(intent)

    }

}
