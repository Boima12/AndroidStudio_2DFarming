package com.example.a2dfarming.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2dfarming.ui.theme.Roboto

@Composable
fun ABuyPanel(
    modifier: Modifier = Modifier,
    price: Long,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(131.dp)
            .background(color = Color(0xFFDCDCDC))
            .clickable(onClick = onClick)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "Mở khóa 2 ô đất này",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "$price$",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF03BD00),
                )
            )
        }
    }
}
