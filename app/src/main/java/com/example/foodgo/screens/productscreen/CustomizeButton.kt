package com.example.foodgo.screens.productscreen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

@Composable
fun CustomizeButton(){
    androidx.compose.foundation.layout.Box(
        modifier = Modifier.clickable {  }
    ) {
        CustomizeBurgerCardButton()
    }

}