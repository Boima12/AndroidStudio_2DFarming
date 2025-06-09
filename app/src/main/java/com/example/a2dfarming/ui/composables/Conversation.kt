package com.example.a2dfarming.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2dfarming.ui.theme.Risque
import com.example.a2dfarming.ui.theme.Roboto

@Composable
fun Conversation(
    @DrawableRes imageRes: Int,
    characterName: String,
    textValue: String,
    isPlayer: Boolean,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF3F3F3))
            .padding(start = 20.dp, top = 50.dp, end = 20.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Character image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(372.dp)
                    .height(208.dp)
            )

            Text(
                text = characterName,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = textValue,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = if (isPlayer) Roboto else Risque,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .width(372.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007DD1)),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = buttonText,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF)
                )
            )
        }
    }
}

