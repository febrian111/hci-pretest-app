package com.hci.pretestapp.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hci.auth.model.ArticleModel
import com.hci.auth.model.ProductModel
import com.hci.kit.extension.disposedBy
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BaseActivity
import com.hci.pretestapp.common.extension.UnspecifiedTypeItem
import com.hci.pretestapp.common.extension.performUpdates
import com.hci.pretestapp.home.listitems.ArticleListItem
import com.hci.pretestapp.home.listitems.ProductListItem
import com.hci.pretestapp.home.listitems.SectionLabelListItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_home.*
import javax.inject.Inject


/**
 * Created by febriansyah on 2020-02-06.
 */
class HomeActivity : BaseActivity<HomeViewModelType>() {

    @Inject
    lateinit var wireframe: HomeWireframe
    @Inject
    lateinit var productAdapter: FastItemAdapter<UnspecifiedTypeItem>
    @Inject
    lateinit var articleAdapter: FastItemAdapter<UnspecifiedTypeItem>

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

        menuProduct.run {
            adapter = productAdapter
            layoutManager =
                GridLayoutManager(this@HomeActivity, 3, GridLayoutManager.VERTICAL, false)
            itemAnimator = null
        }

        menuArticle.run {
            adapter = articleAdapter
            layoutManager =
                LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
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

        viewModel.outputs.shouldUpdateProductMenus
            .subscribe {
                populateProductItems(it)
            }
            .disposedBy(compositeDisposable)

        viewModel.outputs.shouldUpdateArticleMenus
            .subscribe {
                populateArticleItems(it)
            }
            .disposedBy(compositeDisposable)
    }

    private fun populateProductItems(itemViewModels: List<ProductItemViewModel>) {
        val newItems: List<UnspecifiedTypeItem> = itemViewModels.map {
            return@map ProductListItem(
                viewModel = it,
                listener = object : ProductListItem.EventListener{
                    override fun onClickProduct(product: ProductModel) {
                        wireframe.openStaticPage(
                            source = this@HomeActivity,
                            title = product.productName,
                            url = product.link)
                    }

                })
        }
        productAdapter.performUpdates(newItems)
    }

    private fun populateArticleItems(itemViewModels: List<ArticleItemViewModelType>) {
        val newItems: List<UnspecifiedTypeItem> = itemViewModels.map {
            return@map when (it) {
                is ArticleSectionLableItemViewModel -> SectionLabelListItem(it)
                is ArticleItemViewModel -> ArticleListItem(
                    viewModel = it,
                    listener = object : ArticleListItem.EventListener {
                        override fun onClickArticle(article: ArticleModel) {
                            wireframe.openStaticPage(
                                source = this@HomeActivity,
                                title = article.articleTitle,
                                url = article.link)
                        }
                    }
                )
            }
        }
        articleAdapter.performUpdates(newItems)
    }
}
