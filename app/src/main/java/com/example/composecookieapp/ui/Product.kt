package com.example.composecookieapp.ui

import androidx.annotation.DrawableRes

data class Product(
    @DrawableRes val productImage: Int,
    val productPrice: String,
    val productName: String,
    val hasBeenLiked: Boolean = false,
)
