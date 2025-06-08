package br.com.orlando.neto.avaliacaocomposemvi.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Orange

@Composable
fun BottomBarHome() {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf("Home", "Carrinho", "Perfil")
    val icons = listOf(Icons.Outlined.Home, Icons.Outlined.ShoppingCart, Icons.Outlined.Person)

    NavigationBar(
        tonalElevation = 0.dp
    ) {
        items.forEachIndexed { index, label ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = label,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = {
                    Text(
                        text = label,
                        fontSize = 12.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Orange,
                    selectedTextColor = Orange,
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview
@Composable
private fun BottomBarHomePrev() {
    BottomBarHome()
}