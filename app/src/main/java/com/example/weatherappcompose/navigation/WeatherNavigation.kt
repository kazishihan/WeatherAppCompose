package com.example.weatherappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappcompose.screens.MainScreen
import com.example.weatherappcompose.screens.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name ){
        
        // Splash Screen
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }
    
        // Home Screen
        composable(WeatherScreens.MainScreen.name){
            MainScreen(navController = navController)
        }
        
    }
    
}