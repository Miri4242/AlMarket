package com.example.almarket.sehifeler

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
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
import com.example.almarket.viewmodel.VacanciesViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon


@Composable
fun VacanciesMain(
    navController: NavController,
    viewModel: VacanciesViewModel = viewModel()
){
    BackHandler {
        navController.navigate("AnaSehife")
    }
    val vacancies = viewModel.vacancies

    Scaffold(
        topBar ={ MyAppTopBar(navController)},
        bottomBar ={ MyAppBottomBar(navController)}
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(16.dp)
        ){
            items(vacancies) { vacancy ->
                VacanciesCard(
                    vakansiya = vacancy.title,
                    seher = vacancy.city,
                    tarix = vacancy.deadline
                )
            }
        }

    }
}

@Composable
fun VacanciesCard(vakansiya : String,seher : String,tarix : String){
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(top = 12.dp)
            .border(1.dp,Color.Gray, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp),
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
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(16.dp)
                )
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
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(16.dp)
                )
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
    VacanciesMain(navController = rememberNavController(), viewModel = viewModel())
}