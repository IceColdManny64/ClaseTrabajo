package com.example.clasetrabajo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.clasetrabajo.ui.components.TopBarComponent

@Composable
fun AccountsScreen(navController: NavHostController){
    Column(){
        TopBarComponent(title = "Account Screen")
    }

}
