package br.com.orlando.neto.avaliacaocomposemvi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.orlando.neto.avaliacaocomposemvi.R
import br.com.orlando.neto.avaliacaocomposemvi.data.Produto

@Composable
fun ProdutoCard(produto: Produto, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.width(180.dp) // ajuste o tamanho conforme o grid
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f), // imagem quadrada
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Image(
                painter = painterResource(id = produto.imagemRes),
                contentDescription = produto.nome,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = produto.nome,
            fontSize = 14.sp,
            color = Color.Gray,
            maxLines = 2
        )

        Text(
            text = "R$ ${"%.2f".format(produto.preco)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProdutoCardPreview() {
    ProdutoCard(
        produto = Produto(
            id = 1,
            nome = "Chuteira Nike Tiempo 10",
            preco = 245.99,
            imagemRes = R.drawable.chuteira_nike_01,
            descricao = ""
        )
    )
}

