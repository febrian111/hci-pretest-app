package com.hci.data.auth.entity

import com.google.gson.annotations.SerializedName


data class SectionEntity(
    @SerializedName("section") val section: String,
    @SerializedName("section_title") val sectionTitle: String,
    @SerializedName("items") val items: List<ItemEntity>
) {

    data class ItemEntity(
        @SerializedName("article_title") val articleTitle: String,
        @SerializedName("article_image") val articleImage: String,
        @SerializedName("link") val link: String,
        @SerializedName("product_name") val productName: String,
        @SerializedName("product_image") val productImage: String
    )
}