package com.example.almarket.sehifeler

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfilEkrani(navController: NavController){
    Scaffold(
        topBar = {MyAppTopBar(navController)},
        bottomBar = {MyAppBottomBar(navController)}
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(all=16.dp)
        ){
            item {
                ProfilSekliCard()
            }
            item {
                Spacer(modifier = Modifier.padding(top = 24.dp))
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.padding(top = 24.dp))
                Text(
                    text = "Profil məlumatları",
                    fontSize = 24.sp,
                    modifier = Modifier.alpha(0.5f)
                )
            }
        }
    }
}

@Composable
fun  ProfilSekliCard(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Miryusif Babayev",
            fontSize = 24.sp,
        )
        Text(
            text = "+994504863051",
            fontSize = 14.sp,
            modifier = Modifier.alpha(0.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilEkraniPreview() {
    ProfilEkrani(navController = rememberNavController())
}


