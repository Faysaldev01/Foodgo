package com.example.foodgo.screens.productscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodgo.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomizeBurgerCardButton() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(contentColor = Color(0xFFFFF5F5)),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFFFC0C0),RoundedCornerShape(12.dp))

    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.filters),
                    contentDescription = "null",
                    tint = Color(0xFFEF2A39),
                    modifier = Modifier.size(28.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column{
                    Text(
                        text = "Customize Burger",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color(0xFF1D2630)
                    )
                    Text(
                        text = "Add extra toppings and make it your own",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
            Text(
                text = ">",
                color = Color(0xFFEF2A39),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.size(18.dp)
            )
        }
    }

}