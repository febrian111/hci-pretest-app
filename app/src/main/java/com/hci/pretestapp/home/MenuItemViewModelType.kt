package com.hci.pretestapp.home

import com.hci.auth.model.ArticleModel
import com.hci.auth.model.ProductModel

sealed class ArticleItemViewModelType

class ArticleSectionLableItemViewModel(val label: String) : ArticleItemViewModelType()

class ArticleItemViewModel(val article: ArticleModel) : ArticleItemViewModelType(){
    companion object {
        fun create(articles: List<ArticleModel>): List<ArticleItemViewModel> =
            articles.map { ArticleItemViewModel(it) }
    }
}

class ProductItemViewModel(val product: ProductModel) {
    companion object {
        fun create(products: List<ProductModel>): List<ProductItemViewModel> =
            products.map { ProductItemViewModel(it) }
    }
}
