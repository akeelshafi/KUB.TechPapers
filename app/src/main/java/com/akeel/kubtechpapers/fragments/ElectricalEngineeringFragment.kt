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


class ElectricalEngineeringFragment : Fragment() {

        // URLs for each card
        private val urlUnit1 = "https://drive.google.com/drive/folders/1C6oKSh4DLaM85NkmbZER_nuQkkJfPQ9C?usp=sharing"
        private val urlUnit2 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit3 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit4 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit5 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit6 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit7 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"
        private val urlUnit8 = "https://drive.google.com/file/d/1GVnQn3TBgx3c4YSuTfk55oYV1MQmj97i/view?usp=sharing"

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_electrical_engineering, container, false)
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
