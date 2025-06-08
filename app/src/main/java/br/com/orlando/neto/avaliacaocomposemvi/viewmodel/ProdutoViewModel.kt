package br.com.orlando.neto.avaliacaocomposemvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.orlando.neto.avaliacaocomposemvi.intent.ProdutoIntent
import br.com.orlando.neto.avaliacaocomposemvi.data.ProdutoUiState
import br.com.orlando.neto.avaliacaocomposemvi.repository.ProdutoRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProdutoViewModel(
    private val repository: ProdutoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProdutoUiState())
    val state: StateFlow<ProdutoUiState> = _state

    private val _efeitos = MutableSharedFlow<String>()
    val efeitos: SharedFlow<String> = _efeitos

    fun processIntent(intent: ProdutoIntent) {
        when (intent) {
            is ProdutoIntent.CarregarProdutos -> carregar()
        }
    }

    private fun carregar() {
        viewModelScope.launch {
            _state.value = _state.value.copy(carregando = true)
            try {
                val produtos = repository.listarProdutos()
                _state.value = ProdutoUiState(produtos = produtos)
            } catch (e: Exception) {
                _state.value = ProdutoUiState(erro = "Erro ao carregar produtos")
                _efeitos.emit("Erro ao carregar")
            }
        }
    }
}
