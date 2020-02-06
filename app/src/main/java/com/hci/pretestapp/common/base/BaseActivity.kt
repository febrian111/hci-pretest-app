package com.hci.pretestapp.common.base

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by febriansyah on 2020-02-06.
 */

interface ViewModelType

abstract class BaseActivity<VM : ViewModelType> :
    AppCompatActivity(),
    HasSupportFragmentInjector {

    @Inject
    lateinit var viewModel: VM
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    protected val compositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    protected fun displayToast(message: String?) {
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when (it.itemId) {
                android.R.id.home -> onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
