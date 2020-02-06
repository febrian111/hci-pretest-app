package com.hci.pretestapp.home

import android.app.Activity
import com.hci.pretestapp.staticpage.StaticPageWireframe


/**
 * Created by febriansyah on 2020-02-07.
 */

class HomeWireframe {

    fun openStaticPage(source: Activity, title: String, url: String) {
        StaticPageWireframe.startStaticPage(source, title, url)
    }
}