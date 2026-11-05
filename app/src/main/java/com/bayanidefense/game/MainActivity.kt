package com.bayanidefense.game

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View
import android.view.WindowManager

class MainActivity : Activity() {
    private lateinit var gameView: WebView

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        gameView = WebView(this)
        gameView.settings.javaScriptEnabled = true
        gameView.settings.domStorageEnabled = true
        gameView.settings.allowFileAccess = true
        gameView.settings.allowContentAccess = true
        gameView.settings.useWideViewPort = true
        gameView.settings.loadWithOverviewMode = true
        gameView.webViewClient = WebViewClient()
        gameView.webChromeClient = WebChromeClient()
        gameView.isVerticalScrollBarEnabled = false
        gameView.isHorizontalScrollBarEnabled = false
        gameView.overScrollMode = View.OVER_SCROLL_NEVER
        setContentView(gameView)

        if (savedInstanceState == null) {
            gameView.loadUrl("file:///android_asset/index.html")
        } else {
            gameView.restoreState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        gameView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (gameView.canGoBack()) gameView.goBack() else super.onBackPressed()
    }

    override fun onDestroy() {
        gameView.destroy()
        super.onDestroy()
    }
}
