package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.NavigationBarHome
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProdutoViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen() {
    val viewModel: ProdutoViewModel = koinViewModel()

    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            ProdutoScreen()

            Spacer(modifier = Modifier.height(16.dp))

            ProdutoScreen(viewModel)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}
