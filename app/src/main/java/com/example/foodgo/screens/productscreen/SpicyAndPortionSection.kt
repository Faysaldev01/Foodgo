package com.example.foodgo.screens.productscreen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpicyAndPortionSection(orderState: BurgerOrderState){
    Row(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Spicy Slider Section
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp)
        ) {
            Text(
                text = "Spicy",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Slider(
                value = orderState.spicyLevel,
                onValueChange = { orderState.spicyLevel = it },
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFFEF2A39),
                    inactiveTickColor = Color(0xFFF5F5F5)
                ),
                thumb = {
                    Box(
                        modifier = Modifier
                            .size(width = 12.dp, height = 22.dp)
                            .shadow(
                                elevation = 6.dp,
                                shape = RoundedCornerShape(10.dp),
                                spotColor = Color(0x40EF2A39)
                            )
                            .background(Color(0xFFEF2A39), RoundedCornerShape(10.dp))
                    )
                },
                track = { sliderState ->
                    SliderDefaults.Track(
                        sliderState = sliderState,
                        modifier = Modifier.height(4.dp),
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xFFEF2A39),
                            inactiveTickColor = Color(0xFFF2F2F2)
                        )
                    )
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Mild", fontSize = 10.sp, color = Color(0xFF22C55E))
                Text(text = "Hot", fontSize = 10.sp, color = Color(0xFFEF2A39))
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Portion Counter
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Portion", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(12.dp),
                            spotColor = Color(0x55EF2A39)
                        )
                        .background(Color(0xFFEF2A39), RoundedCornerShape(12.dp))
                        .clickable {
                            if (orderState.quantity > 1) orderState.quantity--
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "-",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = "${orderState.quantity}",
                    modifier = Modifier.padding(horizontal = 4.dp),
                    color = Color(0xFF1D1D1D),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(12.dp),
                            spotColor = Color(0x55EF2A39)
                        )
                        .background(Color(0xFFEF2A39), RoundedCornerShape(12.dp))
                        .clickable { orderState.quantity++ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }


}