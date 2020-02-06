package com.hci.pretestapp.staticpage

import android.app.Activity
import com.hci.pretestapp.common.extension.start


class StaticPageWireframe {
    companion object {

        const val INTENT_TITLE = "StaticPageWireframe.INTENT_TITLE"
        const val INTENT_URL = "StaticPageWireframe.INTENT_URL"

        fun startStaticPage(source: Activity, title: String?, url: String) {
            source.start(StaticPageActivity::class.java) {
                putExtra(INTENT_TITLE, title)
                putExtra(INTENT_URL, url)
            }
        }
    }
}
