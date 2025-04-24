package com.example.almarket.sehifeler

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.almarket.viewmodel.NotificationsViewModel

@Composable
fun FullNotificationMain(navController: NavController,notificationID:Int){
    val viewModel : NotificationsViewModel = viewModel()
    val notification = viewModel.notifications.find { it.id == notificationID }
    Scaffold(
        topBar = {MyAppTopBar(navController)},
        bottomBar = {MyAppBottomBar(navController)}
    ) {paddingValues ->
        if(notification !=null)
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                item{
                    Text(
                        text = notification.basliq,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = notification.metn,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = notification.tarix,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun FullNotificationMainPreview() {
    FullNotificationMain(navController = rememberNavController(), notificationID = 1)
}