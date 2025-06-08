package br.com.orlando.neto.avaliacaocomposemvi.di

import br.com.orlando.neto.avaliacaocomposemvi.repository.ProdutoRepository
import br.com.orlando.neto.avaliacaocomposemvi.repository.ProdutoRepositoryFake
import br.com.orlando.neto.avaliacaocomposemvi.viewmodel.ProdutoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<ProdutoRepository> { ProdutoRepositoryFake() }
    viewModel { ProdutoViewModel(get()) }
}
