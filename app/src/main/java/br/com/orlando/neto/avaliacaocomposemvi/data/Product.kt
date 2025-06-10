package br.com.orlando.neto.avaliacaocomposemvi.data

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val imageRes: Int,
    val description: String
)
