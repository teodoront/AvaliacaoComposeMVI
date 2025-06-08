package br.com.orlando.neto.avaliacaocomposemvi.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PerfilScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Perfil",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenScreenPreview() {
    PerfilScreen()
}
