package com.example.a2dfarming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2dfarming.ui.pages.navigation.Navigator
import com.example.a2dfarming.ui.theme._2DFarmingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigator()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _2DFarmingTheme {
        Navigator()
    }
}