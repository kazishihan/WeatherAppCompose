package com.example.weatherappcompose.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview
@Composable
fun MainScreen(navController: NavController?=null){
   Text(text = "Home Screen")
}