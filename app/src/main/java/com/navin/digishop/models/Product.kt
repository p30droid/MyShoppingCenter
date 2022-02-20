package com.navin.digishop.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val brand: String,
    val catId: String,
    val catName: String,
    val count: String,
    val discount: String,
    val fullDescription: String,
    val gallery: List<Gallery>,
    val garanti: String,
    val icon: String,
    val id: String,
    val price: String,
    val rate: String,
    val shortDescription: String,
    val special: String,
    val title: String
): Parcelable