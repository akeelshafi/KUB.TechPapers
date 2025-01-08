package com.akeel.kubtechpapers

import android.annotation.SuppressLint
import android.net.http.SslError
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akeel.kubtechpapers.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val binding: ActivityResultBinding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialize WebView
        val webView: WebView = findViewById(R.id.web_view)

        // Enable JavaScript
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Set WebViewClient to handle navigation
        webView.webViewClient = object : WebViewClient() {
            @SuppressLint("WebViewClientOnReceivedSslError")
            override fun onReceivedSslError(
                view: WebView?, handler: SslErrorHandler?, error: SslError?
            ) {
                handler?.proceed()  // Ignore SSL errors (not recommended for production)
            }
        }

        // Set WebChromeClient for better handling of web page loading
        webView.webChromeClient = WebChromeClient()

        // Load the URL
        webView.loadUrl("https://www.kashmiruniversity.net/Examination.aspx")

        // Set up window insets (Edge-to-edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
