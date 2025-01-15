package com.akeel.kubtechpapers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaperDisplayActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_display)

        // Initialize the WebView and ProgressBar
        webView = findViewById(R.id.paperDisplay_web_view)
        progressBar = findViewById(R.id.paperProgressBar)

        // Setup for edge-to-edge support (for system bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the URL from the intent
        val url = intent.getStringExtra("URL")

        // WebView settings
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            // Show ProgressBar when page starts loading
            override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = ProgressBar.VISIBLE // Show ProgressBar
            }

            // Hide ProgressBar when page finishes loading
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = ProgressBar.GONE // Hide ProgressBar
            }
        }

        // Check if the URL is available and load it
        if (url != null) {
            webView.loadUrl(url)
        } else {
            // Handle the case where URL is null or invalid
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
