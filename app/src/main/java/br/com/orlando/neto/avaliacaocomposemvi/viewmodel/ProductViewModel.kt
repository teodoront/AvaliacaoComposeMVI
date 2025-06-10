package br.com.orlando.neto.avaliacaocomposemvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.orlando.neto.avaliacaocomposemvi.intent.ProductIntent
import br.com.orlando.neto.avaliacaocomposemvi.data.ProductUiState
import br.com.orlando.neto.avaliacaocomposemvi.repository.ProdutoRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProdutoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductUiState())
    val state: StateFlow<ProductUiState> = _state

    private val _efeitos = MutableSharedFlow<String>()
    val efeitos: SharedFlow<String> = _efeitos

    fun processIntent(intent: ProductIntent) {
        when (intent) {
            is ProductIntent.LoadProducts -> carregar()
        }
    }

    private fun carregar() {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            try {
                val produtos = repository.listarProdutos()
                _state.value = ProductUiState(products = produtos)
            } catch (e: Exception) {
                _state.value = ProductUiState(error = "Erro ao carregar produtos")
                _efeitos.emit("Erro ao carregar")
            }
        }
    }
}
