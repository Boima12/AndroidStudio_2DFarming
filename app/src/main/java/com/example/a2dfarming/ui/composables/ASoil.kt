package com.example.a2dfarming.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2dfarming.ui.theme.Roboto

@Composable
fun ASoil(
    @DrawableRes imageRes: Int,
    timerText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(100.dp)
                .clickable { onClick( /* do something */ ) }
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Soil",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = timerText,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight.W400,
                color = Color(0xFF000000),
            )
        )
    }
}