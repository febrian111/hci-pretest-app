package com.hci.auth.model

data class SectionModel(val section: String,
                        val sectionTitle: String,
                        val products: List<ProductModel>,
                        val articles: List<ArticleModel>)
