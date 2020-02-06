package com.hci.pretestapp.home

import android.os.Bundle
import android.view.View
import com.hci.kit.extension.disposedBy
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_home.*


/**
 * Created by febriansyah on 2020-02-06.
 */
class HomeActivity : BaseActivity<HomeViewModelType>(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.inputs.onViewLoaded()

        initView()
        bindViewModel()
        bindViewEvent()
    }

    private fun initView() {
        toolbarTitle.text = getString(R.string.label_home_credit_idn)
    }

    private fun bindViewEvent() {
        actionRetry.setOnClickListener {
            viewModel.inputs.onViewLoaded()
            wrapperErrorPage.visibility = View.GONE
        }
    }

    private fun bindViewModel() {
        viewModel.outputs.showProgressBar
            .subscribe { switchProgressDialogState(it) }
            .disposedBy(compositeDisposable)

        viewModel.outputs.showErrorPage
            .map { if (it) View.VISIBLE else View.GONE }
            .subscribe {
                wrapperErrorPage.visibility = it
            }
            .disposedBy(compositeDisposable)
    }
}
