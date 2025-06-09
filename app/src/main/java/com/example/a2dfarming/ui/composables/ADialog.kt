package com.example.a2dfarming.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2dfarming.ui.theme.Roboto


@Composable
fun ADialog(
    title: String,
    titleColor: Color,
    description: String,
    descriptionColor: Color,
    button1Text: String,
    button1TextColor: Color,
    button1Color: Color,
    onButton1Click: () -> Unit,
    modifier: Modifier = Modifier,
    button1Height: Dp = 50.dp,
    button1FontSize: TextUnit = TextUnit.Unspecified,
    button1FontWeight: FontWeight = FontWeight.Normal
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0x803B3B3B))
            .padding(start = 30.dp, end = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color(0xFFF3F3F3), shape = RoundedCornerShape(10.dp))
                .padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = 30.dp),
            verticalArrangement = Arrangement.spacedBy(65.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = titleColor,
                )
            )

            Text(
                text = description,
                modifier = Modifier.widthIn(280.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = descriptionColor,
                    textAlign = TextAlign.Center,
                )
            )

            AButton(
                text = button1Text,
                onClick = onButton1Click,
                isFullWidth = true,
                height = button1Height,
                fontSize = button1FontSize,
                fontWeight = button1FontWeight,
                textColor = button1TextColor,
                backgroundColor = button1Color
            )
        }
    }
}