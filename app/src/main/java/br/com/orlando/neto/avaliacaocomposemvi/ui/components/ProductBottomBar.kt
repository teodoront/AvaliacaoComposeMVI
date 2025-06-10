package br.com.orlando.neto.avaliacaocomposemvi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.Orange
import br.com.orlando.neto.avaliacaocomposemvi.ui.theme.White

@Composable
fun ProductBottomBar(
    modifier: Modifier = Modifier,
    onToAddClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onToAddClick,
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = White
            )
        ) {
            Text(text = "Adicionar no carrinho", fontSize = 18.sp)
        }

        OutlinedButton(
            onClick = onCartClick,
            modifier = Modifier
                .size(50.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Orange),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = White,
                contentColor = Orange
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Carrinho"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductBottomBarPreview() {
    ProductBottomBar(
        onToAddClick = {},
        onCartClick = {}
    )
}
