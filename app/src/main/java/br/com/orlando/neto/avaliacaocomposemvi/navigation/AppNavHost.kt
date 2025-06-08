import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.NavigationBarHome
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.CarrinhoScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.HomeScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.PerfilScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBarHome(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }
            composable("carrinho") {
                CarrinhoScreen()
            }
            composable("perfil") {
                PerfilScreen()
            }
        }
    }
}
