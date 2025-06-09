package com.example.a2dfarming.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a2dfarming.datas.SeedTimeValues
import com.example.a2dfarming.datas.SeedYoungRes
import com.example.a2dfarming.models.Soil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.a2dfarming.R
import com.example.a2dfarming.datas.SeedGrowRes


class GameVM : ViewModel() {
    var isTruthEnding by mutableStateOf(false)
    var cutsceneNum by mutableIntStateOf(0)
    var currentCash by mutableLongStateOf(10L)
    var currentSeedID by mutableIntStateOf(1)
    var currentRowLevel by mutableIntStateOf(1)

    val soil1 = Soil()
    val soil2 = Soil()
    val soil3 = Soil()
    val soil4 = Soil()
    val soil5 = Soil()
    val soil6 = Soil()
    val soil7 = Soil()
    val soil8 = Soil()
    val soil9 = Soil()
    val soil10 = Soil()
    val soil11 = Soil()
    val soil12 = Soil()
    val soil13 = Soil()
    val soil14 = Soil()

    // safe fall
    val soil15 = Soil()


    // miscellaneous
    private val TAG = "GameVM"


    fun checkAvailable(soilID: Int): Boolean {
        return when (soilID) {
            1 -> soil1.isAvailable
            2 -> soil2.isAvailable
            3 -> soil3.isAvailable
            4 -> soil4.isAvailable
            5 -> soil5.isAvailable
            6 -> soil6.isAvailable
            7 -> soil7.isAvailable
            8 -> soil8.isAvailable
            9 -> soil9.isAvailable
            10 -> soil10.isAvailable
            11 -> soil11.isAvailable
            12 -> soil12.isAvailable
            13 -> soil13.isAvailable
            14 -> soil14.isAvailable
            else -> false
        }
    }


    fun retrieveSoil(soilID: Int): Soil {
        return when (soilID) {
            1 -> soil1
            2 -> soil2
            3 -> soil3
            4 -> soil4
            5 -> soil5
            6 -> soil6
            7 -> soil7
            8 -> soil8
            9 -> soil9
            10 -> soil10
            11 -> soil11
            12 -> soil12
            13 -> soil13
            14 -> soil14
            else -> soil15
        }
    }


    fun retrieveYoungRes(seedID: Int): Int {
        return when (seedID) {
            1 -> SeedYoungRes.seed1
            2 -> SeedYoungRes.seed2
            3 -> SeedYoungRes.seed3
            4 -> SeedYoungRes.seed4
            5 -> SeedYoungRes.seed5
            6 -> SeedYoungRes.seed6
            7 -> SeedYoungRes.seed7
            8 -> SeedYoungRes.seed8
            9 -> SeedYoungRes.seed9
            10 -> SeedYoungRes.seed10
            11 -> SeedYoungRes.seed11
            12 -> SeedYoungRes.seed12
            13 -> SeedYoungRes.seed13
            14 -> SeedYoungRes.seed14
            15 -> SeedYoungRes.seed15
            else -> R.drawable.duy
        }
    }


    fun retrieveGrowRes(seedID: Int): Int {
        return when (seedID) {
            1 -> SeedGrowRes.seed1
            2 -> SeedGrowRes.seed2
            3 -> SeedGrowRes.seed3
            4 -> SeedGrowRes.seed4
            5 -> SeedGrowRes.seed5
            6 -> SeedGrowRes.seed6
            7 -> SeedGrowRes.seed7
            8 -> SeedGrowRes.seed8
            9 -> SeedGrowRes.seed9
            10 -> SeedGrowRes.seed10
            11 -> SeedGrowRes.seed11
            12 -> SeedGrowRes.seed12
            13 -> SeedGrowRes.seed13
            14 -> SeedGrowRes.seed14
            15 -> SeedGrowRes.seed15
            else -> R.drawable.duy
        }
    }


    fun retrieveTimer(): Int {
        return when (currentSeedID) {
            1 -> SeedTimeValues.seed1
            2 -> SeedTimeValues.seed2
            3 -> SeedTimeValues.seed3
            4 -> SeedTimeValues.seed4
            5 -> SeedTimeValues.seed5
            6 -> SeedTimeValues.seed6
            7 -> SeedTimeValues.seed7
            8 -> SeedTimeValues.seed8
            9 -> SeedTimeValues.seed9
            10 -> SeedTimeValues.seed10
            11 -> SeedTimeValues.seed11
            12 -> SeedTimeValues.seed12
            13 -> SeedTimeValues.seed13
            14 -> SeedTimeValues.seed14
            15 -> SeedTimeValues.seed15
            else -> 10
        }
    }


    fun growing(soilID: Int) {
        viewModelScope.launch {
            val selectedSoil = retrieveSoil(soilID)
            val timer = retrieveTimer()

            selectedSoil.isAvailable = false
            selectedSoil.currentSeedID = currentSeedID
            selectedSoil.imageRes = retrieveYoungRes(currentSeedID)
            selectedSoil.timerValue = timer

            while (selectedSoil.timerValue > 0) {
                delay(1000L)
                selectedSoil.timerValue--
            }

            if (selectedSoil.timerValue <= 0) {
                selectedSoil.imageRes = retrieveGrowRes(selectedSoil.currentSeedID)
            } else {
                Log.e(TAG, selectedSoil.timerValue.toString() + " selectedSoil's timer is larger than zero!")
            }
        }
    }
}
