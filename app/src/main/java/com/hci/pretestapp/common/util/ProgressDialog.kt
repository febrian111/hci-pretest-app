package com.hci.pretestapp.common.util

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.view.InflateException
import com.hci.pretestapp.R
import java.io.FileNotFoundException
import java.lang.reflect.InvocationTargetException

class ProgressDialog(context: Context) : Dialog(context) {

    companion object {
        fun buildProgressDialog(context: Context): ProgressDialog? {
            return try {
                ProgressDialog(context, R.layout.layout_loading_progress_dialog)
            } catch (e: FileNotFoundException) {
                null
            } catch (e: InvocationTargetException) {
                null
            } catch (e: InflateException) {
                null
            } catch (e: Resources.NotFoundException) {
                null
            }
        }
    }

    constructor(context: Context, layoutResId: Int, isCancelable: Boolean = false) : this(context) {
        setupDefaultView(layoutResId, isCancelable)
    }

    private fun setupDefaultView(layoutResId: Int, isCancelable: Boolean) {
        setContentView(layoutResId)
        setCancelable(isCancelable)
        setCanceledOnTouchOutside(isCancelable)
    }
}