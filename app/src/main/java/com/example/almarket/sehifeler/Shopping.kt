package com.example.almarket.sehifeler

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.almarket.model.Product
import com.example.almarket.viewmodel.ProductViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingMain(navController: NavController? = null, viewModel: ProductViewModel = viewModel()) {
    val productList by viewModel.products.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            MyAppTopBar(navController)
        },
        bottomBar = {
            MyAppBottomBar(navController)
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productList) { product ->
                ProductCard(product = product)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(product.image)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = product.title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(140.dp)
//            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Text(
                text = product.category,
                fontSize = 13.sp,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(4.dp))

            Card (
                modifier = Modifier
                    .height(25.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow
                )
            ){
                Text(
                    text = "₺${product.price}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Thin,
                    color = Color.Gray
                )
            }
        }
    }
}