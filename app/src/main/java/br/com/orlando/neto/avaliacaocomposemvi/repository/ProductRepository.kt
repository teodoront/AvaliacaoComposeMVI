package br.com.orlando.neto.avaliacaocomposemvi.repository

import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.constants.TextConstants
import br.com.orlando.neto.avaliacaocomposemvi.data.Product

interface ProdutoRepository {
    suspend fun listarProdutos(): List<Product>
}

class ProdutoRepositoryFake : ProdutoRepository {
    override suspend fun listarProdutos(): List<Product> {
        val description = TextConstants.DESCRICAO_AIR_MAX
        return listOf(
            Product(1, "Chuteira Nike Tiempo 10", 245.99, R.drawable.chuteira_nike_01, description),
            Product(2, "Nike Air Max Dn Essential", 699.00, R.drawable.nike_air_max_02, description),
            Product(3, "Nike Air Max 2013", 920.00, R.drawable.nike_airmike_03, description),
            Product(4, "Nike Air Zoom Upturn SC", 399.99, R.drawable.nike_air_zoom_04, description)
        )
    }
}