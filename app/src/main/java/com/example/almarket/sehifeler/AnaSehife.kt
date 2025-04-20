package com.example.almarket.sehifeler

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.almarket.R

@Composable
fun AnaSehifeEkrani(navController: NavController) {
    Scaffold(
        topBar = { MyAppTopBar(navController) },
                bottomBar = { MyAppBottomBar(navController = navController) }
    ) { paddingValues ->
        LazyColumn (modifier = Modifier.padding(paddingValues)){
            item{
                MyAppMarketCard()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar(navController: NavController) {
    Surface (
        modifier = Modifier
            .border(width = 0.5.dp, color = Color.Black)
    ){
        TopAppBar(
            title = { Text("") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "Profil",
                        modifier = Modifier.size(40.dp)
                    )
                }
            },
            actions = {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                IconButton(onClick = {navController.navigate("Vacancies")}) {
                    Icon(
                        imageVector = Icons.Outlined.Call,
                        contentDescription = "Vacancies",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Red,
                    )
                }
                    Text(
                        text = "Vakansiyalar",
                        fontSize = 8.sp,
                        color = Color.Red

                    )
            }
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = {navController.navigate("Notifications")}) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notification",
                            modifier = Modifier.size(35.dp),
                            tint = Color.Red
                        )
                    }
                    Text(
                        text = "Bildirişlər",
                        fontSize = 8.sp,
                        color = Color.Red
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

    }
}

@Composable
fun MyAppBottomBar(navController: NavController) {
    Surface (
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ){
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                selected = false,
                onClick = { navController.navigate("AnaSehife") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Shop") },
                selected = false,
                onClick = { navController.navigate("Shopping") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.LocationOn, contentDescription = "Location") },
                selected = false,
                onClick = { navController.navigate("Location") }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                selected = false,
                onClick = { navController.navigate("Profil") }
            )
        }
    }
}

@Composable
fun MyAppMarketCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Icon(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Profil",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(40.dp)
            )
            Text(
                text = "0.00₼",
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Image(
                painter = painterResource(R.drawable.barcode),
                contentDescription = "Barcode",
                modifier = Modifier
                    .size(height = 80.dp, width = 240.dp)
            )
            Text(
                text = "2000 0000 0059 4115",
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnaSehifeEkraniPreview() {
    AnaSehifeEkrani(navController = rememberNavController())
}