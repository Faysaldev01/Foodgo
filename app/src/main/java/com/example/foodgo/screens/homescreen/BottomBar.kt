package com.example.foodgo.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodgo.R

@Preview
@Composable
fun BottomBar (
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xFFEF2A39))
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onHomeClick) {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onProfileClick) {
                Icon(
                    painter = painterResource(R.drawable.user),
                    contentDescription = "Profile",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(32.dp))

            IconButton(onClick = onCommentClick) {
                Icon(
                    painter = painterResource(R.drawable.comment),
                    contentDescription = "Comment",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

//        Box(
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .offset(y=((-10).dp))
//                .size(56.dp)
//                .clip(CircleShape)
//                .background(Color(0xFFEF2A39)),
//            contentAlignment = Alignment.Center
//        ) {
//            IconButton(onClick = {}) {
//                Icon(
//                    painter = painterResource(R.drawable.add),
//                    contentDescription = "Favorite",
//                    tint = Color.White,
//                    modifier = Modifier.size(24.dp)
//                )
//            }
//        }
    }
    
}