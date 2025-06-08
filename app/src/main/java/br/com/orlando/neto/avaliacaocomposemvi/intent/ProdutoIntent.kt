package br.com.orlando.neto.avaliacaocomposemvi.intent

sealed class ProdutoIntent {
    object CarregarProdutos : ProdutoIntent()
}