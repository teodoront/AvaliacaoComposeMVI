package br.com.orlando.neto.avaliacaocomposemvi.data

data class ProductUiState(
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
