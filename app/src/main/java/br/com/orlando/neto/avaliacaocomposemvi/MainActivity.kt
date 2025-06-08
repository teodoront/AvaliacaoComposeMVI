package br.com.orlando.neto.avaliacaocomposemvi

import AppNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.orlando.neto.avaliacaocomposemvi.di.appModule
import br.com.orlando.neto.avaliacaocomposemvi.ui.view.HomeScreen
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
            //HomeScreen()
            AppNavHost()
        }
    }
}

