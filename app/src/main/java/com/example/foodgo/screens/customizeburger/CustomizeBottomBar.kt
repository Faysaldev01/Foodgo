package com.example.foodgo.screens.customizeburger

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomizeBottomBar(
    finalTotalPrice: Int,
    onOrderNowClick: () -> Unit
){
    Surface(
        shadowElevation = 12.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Total",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Rs. ",
                        color = Color(0xFFEF383A),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$finalTotalPrice",
                        color = Color(0xFF2D2D2D),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = onOrderNowClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF383A)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .height(52.dp)
                    .width(170.dp)
            ) {
                Text(
                    text = "ORDER NOW",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}