package br.com.orlando.neto.avaliacaocomposemvi.repository

import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.constants.TextConstants
import br.com.orlando.neto.avaliacaocomposemvi.data.Produto

interface ProdutoRepository {
    suspend fun listarProdutos(): List<Produto>
}

class ProdutoRepositoryFake : ProdutoRepository {
    override suspend fun listarProdutos(): List<Produto> {
        val descricao = TextConstants.DESCRICAO_AIR_MAX
        return listOf(
            Produto(1, "Chuteira Nike Tiempo 10", 245.99, R.drawable.chuteira_nike_01, descricao),
            Produto(2, "Nike Air Max Dn Essential", 699.00, R.drawable.nike_air_max_02, descricao),
            Produto(3, "Nike Air Max 2013", 920.00, R.drawable.nike_airmike_03, descricao),
            Produto(4, "Nike Air Zoom Upturn SC", 399.99, R.drawable.nike_air_zoom_04, descricao)
        )
    }
}