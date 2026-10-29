package com.example.foodgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.foodgo.screens.customizeburger.BurgerHeaderSection
import com.example.foodgo.screens.customizeburger.CustomizeBurgerScreen
import com.example.foodgo.screens.homescreen.HomeScreen
import com.example.foodgo.screens.productscreen.ProductDetailsScreen
import com.example.foodgo.ui.theme.FoodgoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodgoTheme {

                CustomizeBurgerScreen(
                    onBackClick = {},
                    onOrderNowClick = {}
                )
            }
        }
    }
}

