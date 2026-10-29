package com.example.foodgo.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodgo.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val rating: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)

@Composable
fun ProductGridCard(
    product: Product,
    onProductClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = Color.Black.copy(alpha = 0.08f)
            )
            .clickable { onProductClick() },
        shape = RoundedCornerShape(24.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
//            Product Image
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

//            Product Name / Title
            Text(
                text = product.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF231714)
            )
//            Subtitle / Category
            Text(
                text = product.category,
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

//            Rating aur Heart Icon Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Rating
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "Rating",
                        tint = Color(0xFFFF9800),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = product.rating,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF231714)
                    )
                }
//                Heart Icon
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (product.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (product.isFavorite) Color.Red else Color(0xFF3C2F2F)
                    )
                }
            }
        }
    }

}

@Composable
fun ProductGridSection (
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    onFavoriteClick: (Product) -> Unit
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products, key = {it.id}) { product ->
            ProductGridCard(
                product = product,
                onProductClick = {onProductClick(product)},
                onFavoriteClick = {onFavoriteClick(product)}
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductGridPreview () {

    val sampleProducts = remember {
        mutableStateListOf(
            Product(1,"Cheeseburger","Wendy's Burger","4.9",R.drawable.wendy),
            Product(2, "Hamburger","Veggie Burger","4.8",R.drawable.veggie),
            Product(3,"Hamburger","Chicken Burger","4.6",R.drawable.chicken),
            Product(4,"Hamburger","Fried Chicken Burger", "4.5",R.drawable.fired_chicken)
        )
    }

    ProductGridSection(
        products = sampleProducts,
        onProductClick = {},
        onFavoriteClick = { selectedProduct ->
            val index = sampleProducts.indexOf(selectedProduct)
            if (index != -1){
                sampleProducts[index] = sampleProducts[index].copy(
                    isFavorite = !sampleProducts[index].isFavorite
                )
            }

        }
    )

}