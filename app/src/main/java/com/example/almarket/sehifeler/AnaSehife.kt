package com.example.almarket.sehifeler // Doğru paket adınızı kullandığınızdan emin olun

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.almarket.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSehifeEkrani(navController: NavController) {
    Scaffold(
        topBar = { MyAppTopBar(navController) },
                bottomBar = { MyAppBottomBar(navController = navController) }
    ) { paddingValues ->

        Text(text = "Ana Sayfa İçeriği", modifier = Modifier.padding(paddingValues))
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

@Preview(showBackground = true)
@Composable
fun AnaSehifeEkraniPreview() {
    AnaSehifeEkrani(navController = rememberNavController())
}