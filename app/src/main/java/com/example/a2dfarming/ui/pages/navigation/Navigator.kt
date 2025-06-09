package com.example.a2dfarming.ui.pages.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a2dfarming.ui.pages.A2DFarming
import com.example.a2dfarming.ui.pages.Conversations
import com.example.a2dfarming.ui.pages.Dealer
import com.example.a2dfarming.ui.pages.Shop
import com.example.a2dfarming.viewModels.GameVM
import com.example.a2dfarming.viewModels.SoundManager

@Composable
fun Navigator() {
    val navController = rememberNavController()


    // viewModels
    val gameVM: GameVM = viewModel()
    val soundVM: SoundManager = viewModel()


    NavHost(
        navController = navController,
        startDestination = Routes.Conversations,
    ) {
        composable(Routes.Conversations) {
            Conversations(navController = navController, gameVM = gameVM, soundVM = soundVM)
        }

        composable(Routes.A2DFarming) {
            A2DFarming(navController = navController, gameVM = gameVM, soundVM = soundVM)
        }

        composable(Routes.Shop) {
            Shop(navController = navController, gameVM = gameVM)
        }

        composable(Routes.Dealer) {
            Dealer(navController = navController, gameVM = gameVM, soundVM = soundVM)
        }
    }
}