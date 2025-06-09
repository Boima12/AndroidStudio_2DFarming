package com.example.a2dfarming.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun SeedOption(
    modifier: Modifier = Modifier,
    seedText: String,
    textColor: Color = Color(0xFF000000),
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0x80000000),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = seedText,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight(400),
                color = textColor
            )
        )

        Button(
            onClick = onClick,
            modifier = Modifier
                .width(80.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007DD1)),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Chọn",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
            )
        }
    }
}