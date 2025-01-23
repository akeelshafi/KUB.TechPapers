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

class ElectricalSyllabusFragment : Fragment() {

    // URLs for each card
    private val urlUnit1 = "https://drive.google.com/file/d/1-FxpeU1bWnM4TvYDidHIsKGqHMz5UQzO/view?usp=drive_link"
    private val urlUnit2 = "https://drive.google.com/file/d/1zpPwZZIFSMAhy92ZmrhiZ3iEVWqhmnbp/view?usp=drive_link"
    private val urlUnit3 = "https://drive.google.com/file/d/1tQCEFJsqfIWoUnD0sjg50G-A4oWwDnoZ/view?usp=drive_link"
    private val urlUnit4 = "https://drive.google.com/file/d/1baCfUan_TyfWZzaInzAj3uGsIf6zPAtO/view?usp=drive_link"
    private val urlUnit5 = "https://drive.google.com/file/d/1tE6o2RTJOgC1etL_1maCzZVgQA2RwTQI/view?usp=drive_link"
    private val urlUnit6 = "https://drive.google.com/file/d/1webvV1U2FLo6qxtCYGSCn30FDY0euCH2/view?usp=drive_link"
    private val urlUnit7 = "https://drive.google.com/file/d/1_Ts5JWLOrvFxSgcdoklxXxmuOILMbX0P/view?usp=drive_link"
    private val urlUnit8 = "https://drive.google.com/file/d/194Z4upip8CWs8BBRvnhUzfLn9wbIPnWF/view?usp=drive_link"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_electrical_syllabus, container, false)

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
