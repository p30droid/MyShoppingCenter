package com.navin.digishop.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val img: String
): Parcelable