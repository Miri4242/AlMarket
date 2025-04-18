package com.example.almarket.sehifeler

import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun VacanciesMain(navController: NavController){
    Scaffold(
        topBar ={ MyAppTopBar(navController)},
        bottomBar ={ MyAppBottomBar(navController)}
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(16.dp)
        ){
            item {
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")
                VacanciesCard("Kateqoriya mudiri", "Baki", "30 apr 2025")

            }
        }

    }
}

@Composable
fun VacanciesCard(vakansiya : String,seher : String,tarix : String){
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(top = 12.dp)
    ){
        Column {
            Text(
                text = vakansiya,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(8.dp),
                color = Color.Red
            )
            Row (
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 8.dp)
            ){
                Text(
                    text = "Şəhər : ",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = seher
                )
            }
            Row (
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 8.dp)
            ){
                Text(
                    text = "Son müraciət tarixi : ",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = tarix
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VacanciesMainPreview() {
    VacanciesMain(navController = rememberNavController())
}