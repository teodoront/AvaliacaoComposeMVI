package br.com.orlando.neto.avaliacaocomposemvi

sealed class ProdutoIntent {
    object CarregarProdutos : ProdutoIntent()
}