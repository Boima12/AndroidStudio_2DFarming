package com.example.a2dfarming.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a2dfarming.R
import com.example.a2dfarming.datas.RowPriceValues
import com.example.a2dfarming.datas.SeedPriceValues
import com.example.a2dfarming.datas.SeedSellValues
import com.example.a2dfarming.datas.SeedText
import com.example.a2dfarming.ui.composables.ABuyPanel
import com.example.a2dfarming.ui.composables.AJumpscareDialog
import com.example.a2dfarming.ui.composables.ASoil
import com.example.a2dfarming.ui.pages.navigation.Routes
import com.example.a2dfarming.ui.theme.Roboto
import com.example.a2dfarming.viewModels.GameVM
import com.example.a2dfarming.viewModels.SoundManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun A2DFarming(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    gameVM: GameVM,
    soundVM: SoundManager,
) {
    // data field
    var selectedSeedText by rememberSaveable { mutableStateOf("None") }
    var selectedTextColor = remember { mutableStateOf(Color(0xFF000000)) }


    // miscellaneous
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }



    // main functions
    fun quickRedEffect(obj: MutableState<Color>) {
        scope.launch {
            obj.value = Color(0xFFFF0000)
            delay(300L)
            obj.value = Color(0xFF000000)
        }
    }


    fun retrieveSeedPrice(): Long {
        return when (gameVM.currentSeedID) {
            1 -> SeedPriceValues.seed1
            2 -> SeedPriceValues.seed2
            3 -> SeedPriceValues.seed3
            4 -> SeedPriceValues.seed4
            5 -> SeedPriceValues.seed5
            6 -> SeedPriceValues.seed6
            7 -> SeedPriceValues.seed7
            8 -> SeedPriceValues.seed8
            9 -> SeedPriceValues.seed9
            10 -> SeedPriceValues.seed10
            11 -> SeedPriceValues.seed11
            12 -> SeedPriceValues.seed12
            13 -> SeedPriceValues.seed13
            14 -> SeedPriceValues.seed14
            15 -> SeedPriceValues.seed15
            else -> 100L
        }
    }


    fun retrieveSeedSell(seedID: Int): Long {
        return when (seedID) {
            1 -> SeedSellValues.seed1
            2 -> SeedSellValues.seed2
            3 -> SeedSellValues.seed3
            4 -> SeedSellValues.seed4
            5 -> SeedSellValues.seed5
            6 -> SeedSellValues.seed6
            7 -> SeedSellValues.seed7
            8 -> SeedSellValues.seed8
            9 -> SeedSellValues.seed9
            10 -> SeedSellValues.seed10
            11 -> SeedSellValues.seed11
            12 -> SeedSellValues.seed12
            13 -> SeedSellValues.seed13
            14 -> SeedSellValues.seed14
            15 -> SeedSellValues.seed15
            else -> 100L
        }
    }


    fun placingSeedHandling(soilID: Int) {
        var requiredMoney = retrieveSeedPrice()

        // checking the money
        if (gameVM.currentCash >= requiredMoney) {
            gameVM.currentCash -= requiredMoney
            soundVM.playSfx(R.raw.place_crop)

            // threading
            gameVM.growing(soilID)

        } else {
            soundVM.playSfx(R.raw.error)
            quickRedEffect(selectedTextColor)
        }
    }


    fun soilHandling(soilID: Int) {

        // check to buy if the soil is free
        if (gameVM.checkAvailable(soilID)) {
            placingSeedHandling(soilID)

        } else {
            // check to sell if already have grow seed
            val selectedSoil = gameVM.retrieveSoil(soilID)

            if (selectedSoil.timerValue <= 0) {
                gameVM.currentCash += retrieveSeedSell(selectedSoil.currentSeedID)
                soundVM.playSfx(R.raw.sell_crop)

                if (selectedSoil.currentSeedID == 15) {
                    // play the jumpscare and sfx
                    showDialog = true
                    soundVM.playSfx(R.raw.duy_jumpscare)

                    // trigger the truth ending
                    gameVM.isTruthEnding = true
                }

                selectedSoil.currentSeedID = 0
                selectedSoil.imageRes = R.drawable.soil
                selectedSoil.isAvailable = true
            }
        }

        // other wise just do nothing
    }


    fun rowHandling(price: Long) {
        if (gameVM.currentCash >= price) {
            gameVM.currentCash -= price
            gameVM.currentRowLevel++
            soundVM.playSfx(R.raw.sell_crop)

            if (gameVM.currentCash <= 0) {
                gameVM.currentCash++
            }
        } else {
            soundVM.playSfx(R.raw.error)
            quickRedEffect(selectedTextColor)
        }
    }


    LaunchedEffect(Unit) {
        // Setting up the selected seed text
        when (gameVM.currentSeedID) {
            1 -> selectedSeedText = SeedText.seed1
            2 -> selectedSeedText = SeedText.seed2
            3 -> selectedSeedText = SeedText.seed3
            4 -> selectedSeedText = SeedText.seed4
            5 -> selectedSeedText = SeedText.seed5
            6 -> selectedSeedText = SeedText.seed6
            7 -> selectedSeedText = SeedText.seed7
            8 -> selectedSeedText = SeedText.seed8
            9 -> selectedSeedText = SeedText.seed9
            10 -> selectedSeedText = SeedText.seed10
            11 -> selectedSeedText = SeedText.seed11
            12 -> selectedSeedText = SeedText.seed12
            13 -> selectedSeedText = SeedText.seed13
            14 -> selectedSeedText = SeedText.seed14
            15 -> selectedSeedText = SeedText.seed15
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF3F3F3))
            .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        // soils
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            // soil row 1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                ASoil(
                    imageRes = gameVM.soil1.imageRes,
                    timerText = if (gameVM.soil1.timerValue <= 0) "" else gameVM.soil1.timerValue.toString(),
                    onClick = {
                        soilHandling(1)
                    }
                )

                ASoil(
                    imageRes = gameVM.soil2.imageRes,
                    timerText = if (gameVM.soil2.timerValue <= 0) "" else gameVM.soil2.timerValue.toString(),
                    onClick = {
                        soilHandling(2)
                    }
                )
            }


            // soil row 2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 1) {
                    if (gameVM.currentRowLevel == 1) {
                        ABuyPanel(price = RowPriceValues.row2, onClick = { rowHandling(RowPriceValues.row2) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil3.imageRes,
                            timerText = if (gameVM.soil3.timerValue <= 0) "" else gameVM.soil3.timerValue.toString(),
                            onClick = {
                                soilHandling(3)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil4.imageRes,
                            timerText = if (gameVM.soil4.timerValue <= 0) "" else gameVM.soil4.timerValue.toString(),
                            onClick = {
                                soilHandling(4)
                            }
                        )
                    }
                }
            }


            // soil row 3
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 2) {
                    if (gameVM.currentRowLevel == 2) {
                        ABuyPanel(price = RowPriceValues.row3, onClick = { rowHandling(RowPriceValues.row3) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil5.imageRes,
                            timerText = if (gameVM.soil5.timerValue <= 0) "" else gameVM.soil5.timerValue.toString(),
                            onClick = {
                                soilHandling(5)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil6.imageRes,
                            timerText = if (gameVM.soil6.timerValue <= 0) "" else gameVM.soil6.timerValue.toString(),
                            onClick = {
                                soilHandling(6)
                            }
                        )
                    }
                }
            }


            // soil row 4
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 3) {
                    if (gameVM.currentRowLevel == 3) {
                        ABuyPanel(price = RowPriceValues.row4, onClick = { rowHandling(RowPriceValues.row4) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil7.imageRes,
                            timerText = if (gameVM.soil7.timerValue <= 0) "" else gameVM.soil7.timerValue.toString(),
                            onClick = {
                                soilHandling(7)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil8.imageRes,
                            timerText = if (gameVM.soil8.timerValue <= 0) "" else gameVM.soil8.timerValue.toString(),
                            onClick = {
                                soilHandling(8)
                            }
                        )
                    }
                }
            }


            // soil row 5
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 4) {
                    if (gameVM.currentRowLevel == 4) {
                        ABuyPanel(price = RowPriceValues.row5, onClick = { rowHandling(RowPriceValues.row5) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil9.imageRes,
                            timerText = if (gameVM.soil9.timerValue <= 0) "" else gameVM.soil9.timerValue.toString(),
                            onClick = {
                                soilHandling(9)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil10.imageRes,
                            timerText = if (gameVM.soil10.timerValue <= 0) "" else gameVM.soil10.timerValue.toString(),
                            onClick = {
                                soilHandling(10)
                            }
                        )
                    }
                }
            }


            // soil row 6
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 5) {
                    if (gameVM.currentRowLevel == 5) {
                        ABuyPanel(price = RowPriceValues.row6, onClick = { rowHandling(RowPriceValues.row6) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil11.imageRes,
                            timerText = if (gameVM.soil11.timerValue <= 0) "" else gameVM.soil11.timerValue.toString(),
                            onClick = {
                                soilHandling(11)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil12.imageRes,
                            timerText = if (gameVM.soil12.timerValue <= 0) "" else gameVM.soil12.timerValue.toString(),
                            onClick = {
                                soilHandling(12)
                            }
                        )
                    }
                }
            }


            // soil row 7
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                if (gameVM.currentRowLevel >= 6) {
                    if (gameVM.currentRowLevel == 6) {
                        ABuyPanel(price = RowPriceValues.row7, onClick = { rowHandling(RowPriceValues.row7) })
                    } else {
                        ASoil(
                            imageRes = gameVM.soil13.imageRes,
                            timerText = if (gameVM.soil13.timerValue <= 0) "" else gameVM.soil13.timerValue.toString(),
                            onClick = {
                                soilHandling(13)
                            }
                        )

                        ASoil(
                            imageRes = gameVM.soil14.imageRes,
                            timerText = if (gameVM.soil14.timerValue <= 0) "" else gameVM.soil14.timerValue.toString(),
                            onClick = {
                                soilHandling(14)
                            }
                        )
                    }
                }
            }
        }


        // buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = selectedSeedText,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = { navController.navigate(Routes.Shop) },
                    modifier = modifier
                        .width(90.dp)
                        .height(65.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF44CF5D)),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Shop",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = Roboto,
                            fontWeight = FontWeight(400),
                            color = Color.White
                        )
                    )
                }

                Text(
                    text = "${gameVM.currentCash}$",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight(400),
                        color = selectedTextColor.value,
                    )
                )

                Button(
                    onClick = { navController.navigate(Routes.Dealer) },
                    modifier = modifier
                        .width(90.dp)
                        .height(65.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007DD1)),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Dealer",
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
    }

    // AJumpscareDialog
    if (showDialog) {
        AJumpscareDialog(onClick = { showDialog = false })
    }
}
