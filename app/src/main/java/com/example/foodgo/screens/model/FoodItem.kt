package com.example.foodgo.screens.model

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val prepTime: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)
data class Category(
    val id: Int,
    val name: String
)
