package com.example.foodgo.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    val categories = listOf("All", "Combos", "Sliders", "Classic")

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        bottomBar = {
            BottomBar {}
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBarSection(
                searchQuery = searchQuery,
                onQueryChanged = { newQuery ->
                    searchQuery = newQuery
                },
                onFilterClick = {
                    // Filter icon click par kya hona chahiye, uska code yahan likhein
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            CategoryRow(
                categories = categories,
                selectedCategoryIndex = selectedCategoryIndex,
                onCategorySelected = { index ->
                    selectedCategoryIndex = index
                }
            )

            ProductGridPreview()
        }

    }

}
