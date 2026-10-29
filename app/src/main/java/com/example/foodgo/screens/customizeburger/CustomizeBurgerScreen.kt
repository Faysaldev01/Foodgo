package com.example.foodgo.screens.customizeburger

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodgo.R

@Composable
fun CustomizeBurgerScreen(
    onBackClick:() -> Unit,
    onOrderNowClick: () -> Unit = {}
){
    val basePrice = 1200
    var spicyValue by remember { mutableStateOf(0.5f) }
    var selectedOptions by remember { mutableStateOf(setOf<Int>()) }

    val toppingsList = listOf(
        BurgerOption(id = 1, name = "Tomato", price = 80, imageRes = R.drawable.tomato),
        BurgerOption(id = 2, name = "Onions", price = 60, imageRes = R.drawable.onions),
        BurgerOption(id = 3, name = "Pickles", price = 100, imageRes = R.drawable.pickles),
        BurgerOption(id = 4, name = "Bacons", price = 250, imageRes = R.drawable.bacons),
        BurgerOption(id = 5, name = "Cheese", price = 80, imageRes = R.drawable.cheese),
        BurgerOption(id = 6, name = "Mushroom", price = 90, imageRes = R.drawable.mushroom),
        BurgerOption(id = 7, name = "Avocado", price = 80, imageRes = R.drawable.avocado),
    )

    val sideOptionsList = listOf(
        BurgerOption(id = 8, name = "Mozzarella", price = 300, imageRes = R.drawable.mozzarella),
        BurgerOption(id = 9, name = "Onion", price = 220, imageRes = R.drawable.onion),
        BurgerOption(id = 10, name = "Salad", price = 150, imageRes = R.drawable.salad),
        BurgerOption(id = 11, name = "Coleslaw", price = 180, imageRes = R.drawable.coleslaw),
        BurgerOption(id = 12, name = "Tomato", price = 120, imageRes = R.drawable.fries),
    )

    val totalExtraPrice = selectedOptions.sumOf { id ->
        val item = (toppingsList + sideOptionsList).find { it.id == id}
        item?.price?:0
    }
    val finalTotalPrice = basePrice + totalExtraPrice

    Scaffold(
        topBar = {
            CustomizeTopBar(onBackClick = onBackClick)
        },
        bottomBar = {
            CustomizeBottomBar(
                finalTotalPrice = finalTotalPrice,
                onOrderNowClick = onOrderNowClick
            )
        }
    ) {  innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            BurgerHeaderSection(
                spicyValue = spicyValue,
                onSpicyValueChanged = { newValue ->
                    spicyValue = newValue
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            OptionRowSection(
                title = "Toppings",
                optionsList = toppingsList,
                selectedOptions = selectedOptions,
                onOptionSelected = { id ->
                    selectedOptions = if (selectedOptions.contains(id)){
                        selectedOptions - id
                    } else{
                        selectedOptions + id
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))

            OptionRowSection(
                title = "Side Options",
                optionsList = sideOptionsList,
                selectedOptions = selectedOptions,
                onOptionSelected = { id ->
                    selectedOptions = if (selectedOptions.contains(id)){
                        selectedOptions - id
                    } else{
                        selectedOptions + id
                    }
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}