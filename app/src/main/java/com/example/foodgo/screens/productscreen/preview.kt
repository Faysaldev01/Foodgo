package com.example.foodgo.screens.productscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// یک کلاس فرضی برای پیش‌نمایش (اگر از قبل آن را تعریف نکرده‌اید)
//class BurgerOrderState {
//    var spicyLevel by mutableStateOf(0.5f)
//    var quantity by mutableStateOf(1)
//    val grandTotalPrice: Double
//        get() = quantity * 4.12
//}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ProductDetailsScreenPreview() {
//    // ساخت یک State نمونه برای محیط Preview
//    val sampleOrderState = remember {  }
//
//    ProductDetailsScreen(
//        orderState = sampleOrderState,
//        onNavigateToCustomize = {},
//        onOrderNowClick = {},
//        onBackClick = {}
//    )
//}