package br.com.orlando.neto.avaliacaocomposemvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.orlando.neto.avaliacaocomposemvi.di.appModule
import br.com.orlando.neto.avaliacaocomposemvi.ui.screen.HomeScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.screen.ProdutoScreen
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.AvaliacaoComposeMVITheme
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProdutoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        setContent {
            val viewModel: ProdutoViewModel = getViewModel()
            HomeScreen()
        }
    }
}

