package com.example.a2dfarming.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun AButton(
    text: String,
    onClick: () -> Unit,
    isFullWidth: Boolean = false,
    width: Dp = 332.dp,
    height: Dp = 50.dp,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = Color.White,
    backgroundColor: Color = Color(0xFF007DD1),
    contentAlignment: Alignment = Alignment.Center,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    val widthModifier = if (isFullWidth) Modifier.fillMaxWidth() else Modifier.width(width)

    Box(
        modifier = modifier
            .then(widthModifier)
            .height(height)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 15.dp)
            )
            .padding(contentPadding)
            .clickable { onClick() },
        contentAlignment = contentAlignment
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize,
                fontFamily = Roboto,
                fontWeight = fontWeight,
                color = textColor,
                textAlign = TextAlign.Center,
            )
        )
    }
}
