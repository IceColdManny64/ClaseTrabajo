package com.example.clasetrabajo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable

fun MainMenuScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
      Text("Main Menu")
    }
}