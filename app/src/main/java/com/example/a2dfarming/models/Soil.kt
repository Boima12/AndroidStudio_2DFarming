package com.example.a2dfarming.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.a2dfarming.R

class Soil(
    isAvailable: Boolean = true,
    currentSeedID: Int = 0,
    imageRes: Int = R.drawable.soil,
    timerValue: Int = 0
) {
    var isAvailable by mutableStateOf(isAvailable)
    var currentSeedID by mutableIntStateOf(currentSeedID)
    var imageRes by mutableIntStateOf(imageRes)
    var timerValue by mutableIntStateOf(timerValue)
}
