package com.example.almarket.sehifeler

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.almarket.model.Product
import com.example.almarket.viewmodel.ProductViewModel

@Composable
fun ShoppingMain(navController: NavController, viewModel: ProductViewModel = viewModel()) {
    val productList by viewModel.products.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            MyAppTopBar(navController)
        },
        bottomBar = {
            MyAppBottomBar(navController)
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
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
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = product.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.category,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Null kontrolü ekle
            Text(
                text = product.description ?: "Açıklama yok",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "₺${product.price}",
                fontSize = 16.sp,
                color = Color(0xFF388E3C),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
