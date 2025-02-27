package com.example.clasetrabajo.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable

fun MainMenuScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ){
      Text("Main Menu")
        Button(
            onClick = {navController.navigate("homeScreen")}
        )
        {
            Text("Go to Home Screen")
        }
        Button(
            onClick = {navController.navigate("testScreen")}
        )
        {
            Text("Go to Test Screen")
        }
        Button(
            onClick = {navController.navigate("amScreen")}
        )
        {
            Text("Go to App Screen")
        }
        Button(
            onClick = {navController.navigate("componentsScreen")}
        )
        {
            Text("Go to Components Screen")
        }
    }
}