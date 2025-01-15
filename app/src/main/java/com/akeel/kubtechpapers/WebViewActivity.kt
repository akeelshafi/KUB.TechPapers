package com.akeel.kubtechpapers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // Ensure padding is applied for system bars (status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize WebView and ProgressBar
        progressBar = findViewById(R.id.progressBar)
        webView = findViewById(R.id.syllabus_web_view)

        // Retrieve the URL from the Intent
        val url = intent.getStringExtra("URL")

        if (url != null) {
            // Enable JavaScript
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient() // Open links within the WebView
            webView.webChromeClient = object : WebChromeClient() {
                // Show progress bar while loading the page
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    if (newProgress < 100) {
                        progressBar.visibility = ProgressBar.VISIBLE
                    } else {
                        progressBar.visibility = ProgressBar.GONE
                    }
                }
            }
            // Load the URL in the WebView
            webView.loadUrl(url)
        } else {
            // Handle null URL
            webView.loadUrl("about:blank")
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Handle back press for WebView
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack() // Navigate back in WebView history
            return true
        }
        return super.onKeyDown(keyCode, event) // Default behavior
    }
}
