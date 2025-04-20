package com.example.almarket.sehifeler

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.almarket.viewmodel.NotificationsViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NotificationMain(
    navController: NavController,
    viewModel: NotificationsViewModel
){
    BackHandler {
        navController.navigate("AnaSehife")
    }

    val notifications = viewModel.notifications

    Scaffold (
        topBar = { MyAppTopBar(navController) },
        bottomBar = { MyAppBottomBar(navController)}

    ){ paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(all = 16.dp)
        ) {
            items(notifications){
                notification ->
                    NotificaionCard(
                        basliq = notification.basliq,
                        metn = notification.metn,
                        tarix = notification.tarix,
                        onClick = {
                            navController.navigate("FullNotification/${notification.id}")
                        }
                    )
                Divider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun NotificaionCard(basliq : String,metn : String,tarix : String,onClick:()-> Unit){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp)
        ){
        Text(
            text = basliq,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp, top = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = metn.take(35)+".....",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
                    .padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
            )
            Text(
                text = tarix,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
                    .padding(end = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationMainPreview() {
    NotificationMain(navController = rememberNavController(), viewModel = viewModel())
}