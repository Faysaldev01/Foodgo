package com.example.foodgo.screens.customizeburger

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodgo.R
import com.example.foodgo.screens.productscreen.BurgerOrderState

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BurgerHeaderSection(
    spicyValue: Float,
    onSpicyValueChanged: (Float) -> Unit,

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(240.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.customize),
                contentDescription = "Customize Burger"
            )
        }

        Column(
            modifier = Modifier
                .weight(1.1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Customize Your Burger to Your Tastes. Ultimate Experience",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
                lineHeight = 17.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Spicy",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Slider(
                value = spicyValue,
                onValueChange = onSpicyValueChanged,
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Mild",
                    fontSize = 11.sp,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Hot",
                    fontSize = 11.sp,
                    color = Color(0xFFEF383A),
                    fontWeight = FontWeight.Bold
                )
            }


        }

    }
}