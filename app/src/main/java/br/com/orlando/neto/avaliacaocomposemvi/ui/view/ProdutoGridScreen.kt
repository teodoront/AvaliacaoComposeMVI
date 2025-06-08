package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.orlando.neto.avaliacaocomposemvi.intent.ProdutoIntent
import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.data.Produto
import br.com.orlando.neto.avaliacaocomposemvi.data.ProdutoUiState
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.ProdutoCard
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProdutoViewModel


@Composable
fun ProdutoScreen(viewModel: ProdutoViewModel) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.processIntent(ProdutoIntent.CarregarProdutos)
    }

    if (state.carregando) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        ProdutoScreenContent(state)
    }
}


@Composable
fun ProdutoScreenContent(state: ProdutoUiState) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(state.produtos) { produto ->
            ProdutoCard(produto)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProdutoScreenPreview() {
    val mockState = ProdutoUiState(
        produtos = listOf(
            Produto(1, "Chuteira Nike Tiempo 10", 245.99, R.drawable.chuteira_nike_01,""),
            Produto(2, "Nike Air Max Dn Essential", 699.00, R.drawable.nike_air_max_02, ""),
            Produto(3, "Nike Air Max 2013", 920.00, R.drawable.nike_airmike_03, ""),
            Produto(4, "Nike Air Zoom Upturn SC", 399.99, R.drawable.nike_air_zoom_04, "")
        )
    )

    ProdutoScreenContent(mockState)
}



