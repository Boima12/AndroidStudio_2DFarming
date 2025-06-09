package com.example.a2dfarming.ui.pages

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a2dfarming.R
import com.example.a2dfarming.ui.composables.ADialog
import com.example.a2dfarming.ui.pages.navigation.Routes
import com.example.a2dfarming.ui.theme.Risque
import com.example.a2dfarming.ui.theme.Roboto
import com.example.a2dfarming.viewModels.GameVM
import com.example.a2dfarming.viewModels.SoundManager

@Composable
fun Dealer(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    gameVM: GameVM,
    soundVM: SoundManager,
) {
    // miscellaneous
    var showDialog by remember { mutableStateOf(false) }


    // win checking
    fun winChecking() {
        if (gameVM.isTruthEnding) {

            gameVM.cutsceneNum = 99
            navController.navigate(Routes.Conversations)

        } else if (gameVM.currentCash >= 10000) {

            gameVM.cutsceneNum = 19
            navController.navigate(Routes.Conversations)

        } else {
            showDialog = true

            // play error sfx
            soundVM.playSfx(R.raw.error)
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF3F3F3))
            .padding(start = 20.dp, top = 50.dp, end = 20.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Top
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.thedealer),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(372.dp)
                    .height(208.dp)
            )

            Text(
                text = "Nhà ngươi đã có đủ 10000$ chưa đấy?",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Risque,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }


        // Buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { winChecking() },
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF44CF5D)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Trả 10000$",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }

            Button(
                onClick = { navController.navigate(Routes.A2DFarming) },
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007DD1)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Quay trở lại",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        }
    }


    // Dialog
    if (showDialog) {
        ADialog(
            title = ">:(",
            titleColor = Color(0xFF000000),
            description = "10000$, TA BẢO 10000$ !!!!!",
            descriptionColor = Color(0xFF000000),
            button1Text = "Đóng",
            button1TextColor = Color.White,
            button1Color = Color(0xFF007DD1),
            onButton1Click = { showDialog = false }
        )
    }
}