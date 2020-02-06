package com.hci.pretestapp.staticpage

import android.annotation.SuppressLint
import android.net.http.SslError
import android.os.Bundle
import android.webkit.*
import asia.digiasia.kaspro.staticpage.StaticPageViewModelType
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_static_page.*
import kotlinx.android.synthetic.main.toolbar_action_icon.*


class StaticPageActivity : BaseActivity<StaticPageViewModelType>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_page)

        initView()
        bindViewEvents()
    }

    override fun onDestroy() {
        super.onDestroy()
        swipeRefreshLayout?.isRefreshing = false
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView() {
        toolbarTitle.text = intent?.extras?.getString(StaticPageWireframe.INTENT_TITLE).orEmpty()
        webView.loadUrl(intent?.extras?.getString(StaticPageWireframe.INTENT_URL))

        webView.settings.run {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                swipeRefreshLayout?.isRefreshing = false
            }

            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed()
            }
        }

        swipeRefreshLayout.setOnRefreshListener {
            webView.loadUrl(intent?.extras?.getString(StaticPageWireframe.INTENT_URL))
        }
    }

    private fun bindViewEvents() {
        toolbarLeft.setOnClickListener {
            super.onBackPressed()
        }
    }
}
