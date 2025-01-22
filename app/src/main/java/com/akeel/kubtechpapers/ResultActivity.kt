package com.akeel.kubtechpapers

import android.annotation.SuppressLint
import android.net.http.SslError
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akeel.kubtechpapers.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val binding: ActivityResultBinding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialize WebView and ProgressBar
        webView = findViewById(R.id.result_web_view)
        val progressBar: ProgressBar = findViewById(R.id.result_progress_bar)

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

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = ProgressBar.GONE // Hide progress bar
            }
        }

        // Set WebChromeClient for better handling of web page loading
        webView.webChromeClient = WebChromeClient()

        // Show progress bar while loading
        progressBar.visibility = ProgressBar.VISIBLE

        // Load the URL
        webView.loadUrl("https://www.kashmiruniversity.net/Examination.aspx")

        // Set up window insets (Edge-to-edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK && binding.resultWebView.canGoBack()) {
            binding.resultWebView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
