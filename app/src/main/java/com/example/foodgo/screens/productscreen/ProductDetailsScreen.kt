package com.example.foodgo.screens.productscreen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsScreen(
    orderState: BurgerOrderState,
    onNavigateToCustomize: () -> Unit,
    onOrderNowClick: () -> Unit,
    onBackClick: () -> Unit = {}
){
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            ProductBottomBar(
                orderState = orderState,
                onOrderNowClick = onOrderNowClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            ProductTopBar()

            Spacer(modifier = Modifier.height(16.dp))

            ProductImageSection()

            Spacer(modifier = Modifier.height(16.dp))

            ProductInfoSection()

            Spacer(modifier = Modifier.height(20.dp))

            SpicyAndPortionSection(orderState = orderState)

            Spacer(modifier = Modifier.height(20.dp))

            CustomizeButton()

            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}