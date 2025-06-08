package br.com.orlando.neto.avaliacaocomposemvi.data

data class ProdutoUiState(
    val produtos: List<Produto> = emptyList(),
    val carregando: Boolean = false,
    val erro: String? = null
)
