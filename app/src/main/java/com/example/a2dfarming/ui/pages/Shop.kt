package com.example.a2dfarming.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import com.example.a2dfarming.R
import com.example.a2dfarming.datas.SeedText
import com.example.a2dfarming.ui.composables.SeedOption
import com.example.a2dfarming.ui.pages.navigation.Routes
import com.example.a2dfarming.ui.theme.Roboto
import com.example.a2dfarming.viewModels.GameVM

@Composable
fun Shop(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    gameVM: GameVM,
) {
    // miscellaneous
    val scrollState = rememberScrollState()


    // seedPicker
    fun seedPicker(seedID: Int) {
        gameVM.currentSeedID = seedID

        navController.navigate(Routes.A2DFarming)
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF3F3F3))
            .padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        // Seed selection panel
        Column(
            modifier = Modifier
                .weight(1f)
                .border(width = 1.dp, color = Color(0x80000000), shape = RoundedCornerShape(size = 7.dp))
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            SeedOption(
                seedText = SeedText.seed1,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(1) }
            )

            SeedOption(
                seedText = SeedText.seed2,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(2) }
            )

            SeedOption(
                seedText = SeedText.seed3,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(3) }
            )

            SeedOption(
                seedText = SeedText.seed4,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(4) }
            )

            SeedOption(
                seedText = SeedText.seed5,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(5) }
            )

            SeedOption(
                seedText = SeedText.seed6,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(6) }
            )

            SeedOption(
                seedText = SeedText.seed7,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(7) }
            )

            SeedOption(
                seedText = SeedText.seed8,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(8) }
            )

            SeedOption(
                seedText = SeedText.seed9,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(9) }
            )

            SeedOption(
                seedText = SeedText.seed10,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(10) }
            )

            SeedOption(
                seedText = SeedText.seed11,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(11) }
            )

            SeedOption(
                seedText = SeedText.seed12,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(12) }
            )

            SeedOption(
                seedText = SeedText.seed13,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(13) }
            )

            SeedOption(
                seedText = SeedText.seed14,
                textColor = Color(0xFF000000),
                onClick = { seedPicker(14) }
            )

            SeedOption(
                seedText = SeedText.seed15,
                textColor = Color(0xFFED0000),
                onClick = { seedPicker(15) }
            )
        }


        // Decoration
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hãy chọn hạt giống",
                modifier = Modifier
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )

            Image(
                painter = painterResource(id = R.drawable.shop_deco),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .width(278.dp)
                    .height(208.dp)
            )
        }
    }
}
