package com.example.almarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.almarket.sehifeler.AnaSehifeEkrani
import com.example.almarket.sehifeler.LocationMain
import com.example.almarket.sehifeler.NotificationMain
import com.example.almarket.sehifeler.ProfilEkrani
import com.example.almarket.sehifeler.ShoppingMain
import com.example.almarket.sehifeler.VacanciesMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppNavHost(navController = navController)
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "AnaSehife") {
        composable(route = "AnaSehife") {
            AnaSehifeEkrani(navController = navController)
        }
        composable(route = "Profil"){
            ProfilEkrani(navController)
        }
        composable(route = "Notifications"){
            NotificationMain(navController)
        }
        composable(route = "Vacancies"){
            VacanciesMain(navController)
        }
        composable(route = "Shopping"){
            ShoppingMain(navController)
        }
        composable(route = "Location"){
            LocationMain(navController)
        }
        }
    }


