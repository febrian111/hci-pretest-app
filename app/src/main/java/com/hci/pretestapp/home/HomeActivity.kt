package com.hci.pretestapp.home

import android.os.Bundle
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BaseActivity
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

    }

    private fun bindViewModel() {

    }
}
