package br.com.orlando.neto.avaliacaocomposemvi.intent

sealed class ProductIntent {
    object LoadProducts : ProductIntent()
}