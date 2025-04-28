package com.example.almarket.sehifeler

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.almarket.model.Product
import com.example.almarket.viewmodel.ProductViewModel
import java.io.FilterReader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingMain(navController: NavController? = null, viewModel: ProductViewModel = viewModel()) {
    val productList by viewModel.products.observeAsState(initial = emptyList())

    val categories = remember(productList) {
        productList.map { it.category }.distinct()
    }

    var selectedCategory by remember { mutableStateOf<String?>(null) }

    val filteredProducts = remember(productList, selectedCategory) {
        if (selectedCategory == null) {
            productList
        } else {
            productList.filter { it.category == selectedCategory }
        }
    }

    Scaffold(
        topBar = {
            MyAppTopBar(navController)
        },
        bottomBar = {
            MyAppBottomBar(navController)
        }
    ) { padding ->
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(top = 90.dp, bottom = 130.dp)
        ){
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item{
                    FilterChip(
                        selected = selectedCategory == null,
                        onClick = { selectedCategory = null},
                        label = { Text("Bütün məhsullar")}
                    )
                }
                items(categories){
                    category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category},
                        label = {Text(category)}
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product = product)
            }
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
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Text(
                text = product.category,
                fontSize = 14.sp,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(4.dp))

            Card (
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                )
            ){
                Text(
                    text = "₼${product.price}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 12.dp)
                )
            }
        }
    }
}

