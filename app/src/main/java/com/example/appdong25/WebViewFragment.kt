package com.example.appdong25

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView = view.findViewById<WebView>(R.id.instagramWebView)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()  // 내부에서 열리도록

        webView.loadUrl("https://www.instagram.com/knu.appdong?igsh=dGc4Y2toZnMzYnJv") // ← 동아리 인스타 주소로 바꿔줘
    }
}
