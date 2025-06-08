package br.com.orlando.neto.avaliacaocomposemvi.data

import androidx.annotation.DrawableRes

data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    @DrawableRes val imagemRes: Int,
    val descricao: String
)
