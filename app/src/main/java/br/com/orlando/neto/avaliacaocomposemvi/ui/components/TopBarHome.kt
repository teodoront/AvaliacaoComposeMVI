package br.com.orlando.neto.avaliacaocomposemvi.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome() {
    CenterAlignedTopAppBar(
        title = {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Olá, Neto",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}

@Preview
@Composable
private fun TopBarPrev() {
    TopBarHome()
}