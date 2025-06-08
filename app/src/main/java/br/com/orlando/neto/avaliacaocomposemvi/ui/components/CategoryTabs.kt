package br.com.orlando.neto.avaliacaocomposemvi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Orange

@Composable
fun CategoryTabs() {
    val categories = listOf("Todos", "Tênis", "Botas", "Chuteiras", "Sapatênis")
    var selectedIndex by remember { mutableStateOf(0) }

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
                onClick = { selectedIndex = index },
                modifier = Modifier.padding(end = 0.dp),
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,

                text = {
                    Surface(
                        color = if (selectedIndex == index) Orange else Color.Transparent,
                        contentColor = if (selectedIndex == index) Color.White else Color.Gray,
                        shape = RoundedCornerShape(12.dp),
                        border = if (selectedIndex == index) null else BorderStroke(1.dp, Color.LightGray),
                        modifier = Modifier
                            .defaultMinSize(minWidth = 80.dp)
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
}

@Preview
@Composable
private fun CategoryPrev() {
    CategoryTabs()
}