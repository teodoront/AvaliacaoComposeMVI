package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.orlando.neto.avaliacaocomposemvi.intent.ProductIntent
import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.data.Product
import br.com.orlando.neto.avaliacaocomposemvi.data.ProductUiState
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.ProductCard
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProductViewModel


@Composable
fun ProductContent(viewModel: ProductViewModel, navController: NavController) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.processIntent(ProductIntent.LoadProducts)
    }

    if (state.loading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        ProductScreenContent(state, navController)
    }
}


@Composable
fun ProductScreenContent(state: ProductUiState, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(state.products) { product ->
            ProductCard(product = product, onClick = {
                val name = Uri.encode(product.name)
                val price = Uri.encode("%.2f".format(product.price))
                val imageRes = product.imageRes
                navController.navigate("detalheProduto/$name/$price/$imageRes")
            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductContentPreview() {
    val navController = NavController(LocalContext.current)
    val mockState = ProductUiState(
        products = listOf(
            Product(1, "Chuteira Nike Tiempo 10", 245.99, R.drawable.chuteira_nike_01,""),
            Product(2, "Nike Air Max Dn Essential", 699.00, R.drawable.nike_air_max_02, ""),
            Product(3, "Nike Air Max 2013", 920.00, R.drawable.nike_airmike_03, ""),
            Product(4, "Nike Air Zoom Upturn SC", 399.99, R.drawable.nike_air_zoom_04, "")
        )
    )

    ProductScreenContent(mockState, navController)
}



