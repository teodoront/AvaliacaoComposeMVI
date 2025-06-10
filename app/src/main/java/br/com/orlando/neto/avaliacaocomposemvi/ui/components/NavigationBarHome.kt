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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Lexend
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Orange

@Composable
fun NavigationBarHome(navController: NavController) {
    val items = listOf(
        NavigationItem("Home", Icons.Outlined.Home, "home"),
        NavigationItem("Carrinho", Icons.Outlined.ShoppingCart, "carrinho"),
        NavigationItem("Perfil", Icons.Outlined.Person, "perfil")
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(tonalElevation = 0.dp) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontFamily = Lexend,
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

data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
private fun BottomBarHomePreviewWrapper() {
    val navController = rememberNavController()
    NavigationBarHome(navController = navController)
}

@Preview(showBackground = true)
@Composable
private fun BottomBarHomePrev() {
    BottomBarHomePreviewWrapper()
}