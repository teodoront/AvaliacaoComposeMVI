package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.SearchBarHome
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.TopBarHome
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Orange
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: ProductViewModel = koinViewModel()
    val categories = listOf("Todos", "Tênis", "Botas", "Chuteiras", "Sapatênis")
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        topBar = { TopBarHome() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            SearchBarHome()

            Spacer(modifier = Modifier.height(8.dp))

            ScrollableTabRow(
                selectedTabIndex = selectedIndex,
                edgePadding = 0.dp,
                indicator = {},
                divider = {},
                containerColor = Color.Transparent
            ) {
                categories.forEachIndexed { index, categoria ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        text = {
                            Surface(
                                color = if (selectedIndex == index) Orange else Color.Transparent,
                                contentColor = if (selectedIndex == index) Color.White else Color.Gray,
                                shape = RoundedCornerShape(12.dp),
                                border = if (selectedIndex == index) null else BorderStroke(1.dp, Color.LightGray),
                                modifier = Modifier.defaultMinSize(minWidth = 80.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp, vertical = 6.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = categoria,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (categories[selectedIndex].lowercase() == "todos") {
                ProductContent(viewModel, navController)
            } else {
                CategoryScreen(category = categories[selectedIndex])
            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPrev() {
    val navController = NavController(LocalContext.current)
    HomeScreen(navController)
}
