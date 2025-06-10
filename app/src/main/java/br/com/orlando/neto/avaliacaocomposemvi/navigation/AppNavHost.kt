import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.ui.components.NavigationBarHome
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.CarrinhoScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.DetalheProdutoScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.HomeScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.PerfilScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "carrinho", "perfil")) {
                NavigationBarHome(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(navController)
            }
            composable("carrinho") {
                CarrinhoScreen()
            }
            composable("perfil") {
                PerfilScreen()
            }
            composable(
                "detalheProduto/{nome}/{preco}/{imagemRes}",
                arguments = listOf(
                    navArgument("nome") { type = NavType.StringType },
                    navArgument("preco") { type = NavType.StringType },
                    navArgument("imagemRes") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val nome = backStackEntry.arguments?.getString("nome") ?: ""
                val preco = backStackEntry.arguments?.getString("preco") ?: ""
                val imagemRes = backStackEntry.arguments?.getInt("imagemRes") ?: R.drawable.chuteira_nike_01

                DetalheProdutoScreen(nome, preco, imagemRes, navController)
            }
        }
    }
}

