package com.akeel.kubtechpapers

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        // Set up the progress bar
        progressBar = findViewById(R.id.progressBar)

        // Ensure padding is applied for system bars (status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val webView = findViewById<WebView>(R.id.webView)
        val url = intent.getStringExtra("URL") // Retrieve the URL from Intent

        if (url != null) {
            // Enable JavaScript
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient() // Open links within the WebView
            webView.webChromeClient = object : WebChromeClient() {
                // Show progress bar while loading the page
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    // Show the progress bar when loading
                    if (newProgress < 100) {
                        progressBar.visibility = ProgressBar.VISIBLE
                    } else {
                        // Hide the progress bar when the page is fully loaded
                        progressBar.visibility = ProgressBar.GONE
                    }
                }
            }
            webView.loadUrl(url) // Load the URL in the WebView
        }
    }
}
