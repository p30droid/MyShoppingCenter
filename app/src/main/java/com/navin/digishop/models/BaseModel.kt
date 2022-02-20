package com.navin.digishop.models

data class BaseModel(
    val brands: List<Brand>,
    val categories: List<Category>,
    val AmazingOffer: List<Product>,
    val `data`: Data,
    val discount: List<Product>,
    val makeup: List<Product>,
    val mobile: List<Product>,
    val news: List<New>
)