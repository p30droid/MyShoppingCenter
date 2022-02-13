package com.navin.digishop.models

data class BaseModel(
    val brands: List<Brand>,
    val categories: List<Category>,
    val `data`: Data
)