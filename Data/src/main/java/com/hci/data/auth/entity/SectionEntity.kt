package com.hci.data.auth.entity

import com.google.gson.annotations.SerializedName
import com.hci.auth.model.ArticleModel
import com.hci.auth.model.ProductModel
import com.hci.auth.model.SectionModel


data class SectionEntity(
    @SerializedName("section") val section: String? = null,
    @SerializedName("section_title") val sectionTitle: String? = null,
    @SerializedName("items") val items: List<ItemEntity>? = null
) {

    data class ItemEntity(
        @SerializedName("article_title") val articleTitle: String? = null,
        @SerializedName("article_image") val articleImage: String? = null,
        @SerializedName("link") val link: String? = null,
        @SerializedName("product_name") val productName: String? = null,
        @SerializedName("product_image") val productImage: String? = null
    )

    fun create(): SectionModel {
        return SectionModel(
            section = section.orEmpty(),
            sectionTitle = sectionTitle.orEmpty(),
            products = items?.filter { it.articleTitle.isNullOrEmpty() }?.map {
                ProductModel(
                    link = it.link.orEmpty(),
                    productName = it.productName.orEmpty(),
                    productImage = it.productImage.orEmpty()
                )
            } ?: listOf(),
            articles = items?.filter { it.productName.isNullOrEmpty() }?.map {
                ArticleModel(
                    articleTitle = it.articleTitle.orEmpty(),
                    articleImage = it.articleImage.orEmpty(),
                    link = it.link.orEmpty()
                )
            } ?: listOf()
        )
    }
}