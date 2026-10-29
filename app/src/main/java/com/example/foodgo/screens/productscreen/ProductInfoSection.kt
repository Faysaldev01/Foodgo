package com.example.foodgo.screens.productscreen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodgo.R

@Composable
fun ProductInfoSection(){
    Text(
        text = "Cheeseburger Wendy's Burger",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3C2F2F)
    )

    Spacer(modifier = Modifier.height(6.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.star),
            contentDescription = "Rating Star",
            tint = Color(0xFFFF9633),
            modifier = Modifier.size(17.dp)
        )

        Text(
            text = "4.9 — 26 mins",
            fontSize = 15.sp,
            color = Color.Gray
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "The Cheeseburger Wendy's Burger is a classic fast food burger that packs a punch of flavor in every bite. Made with a juicy beef patty cooked to perfection, it's topped with melted American cheese, crispy lettuce, ripe tomato, and crunchy pickles.",
        fontSize = 16.sp,
        color = Color.Gray,
        lineHeight = 22.sp
    )

}