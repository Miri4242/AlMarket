package com.example.almarket.sehifeler

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                        .padding(start = 28.dp)
                )
            }
            item {
                ProfilButtonsCard("Blogs","Bloglar","Daxil ol və blogları gör")
                ProfilButtonsCard("Personal","Şəxsi məlumatlar","Şəxsi məlumatlarivi idarə et")
                ProfilButtonsCard("Settings","Tənzimləmələr","Dil və bildirişlər")
                ProfilButtonsCard("Password","Şifrəvi dəyiş","Şifrənizi dəyişə bilərsiniz")
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

val iconMap = mapOf(
    "Blogs" to Icons.Default.List,
    "Personal" to Icons.Default.Person,
    "Settings" to Icons.Default.Settings,
    "Password" to Icons.Default.Lock
)

@Composable
fun ProfilButtonsCard(iconName: String,buttonBasliq: String,buttonMetn:String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically, // Dikeyde ortalamak için
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ){
            val icon = iconMap[iconName] ?: Icons.Default.Home // İlgili ikonu map'ten al, yoksa varsayılanı kullan
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon, // Doğru ImageVector'ı buraya atıyoruz
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(32.dp)
                )
                Column {
                    Text(
                        text = buttonBasliq
                    )
                    Text(
                        text = buttonMetn
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilEkraniPreview() {
    ProfilEkrani(navController = rememberNavController())
}


