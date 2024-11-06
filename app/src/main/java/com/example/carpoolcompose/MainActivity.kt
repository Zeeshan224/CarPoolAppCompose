package com.example.carpoolcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarPoolApp()
            }
        }
    }

@Composable
fun CarPoolApp(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login" ){
        composable("login") { LoginScreen(navController)}
        composable("signup"){ SignupScreen(navController)}
    }
}
