package com.example.foodgo.screens.productscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class CustomOption(
    val id: String,
    val name: String,
    val price: Double,
    val imageRes: Int = 0
)

// Overall Customization State
open class BurgerOrderState(
    basePrice: Double = 4.12
) {
    var basePrice by mutableStateOf(basePrice)
    var quantity by mutableStateOf(1)
    var spicyLevel by mutableStateOf(0.5f) // 0f = Mild, 1f = Hot

    // Topping selections
    var selectedToppings = mutableStateOf<Set<CustomOption>>(emptySet())
    var selectedSideOptions = mutableStateOf<Set<CustomOption>>(emptySet())

    // Topping Total
    val toppingsTotalPrice: Double
        get() = selectedToppings.value.sumOf { it.price } + selectedSideOptions.value.sumOf { it.price }

    // Final Total Price
    val grandTotalPrice: Double
        get() = (basePrice + toppingsTotalPrice) * quantity
}
