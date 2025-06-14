package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.SearchBarHome
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.TopBarHome
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductScreen(navController: NavController) {
    val viewModel: ProductViewModel = koinViewModel()


    Scaffold(
        topBar = { TopBarHome() },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            SearchBarHome()

            Spacer(modifier = Modifier.height(16.dp))

            ProductContent(viewModel, navController)
        }
    }
}

@Preview
@Composable
private fun ProductScreenPrev() {
    val navController = NavController(LocalContext.current)
    ProductScreen(navController)
}