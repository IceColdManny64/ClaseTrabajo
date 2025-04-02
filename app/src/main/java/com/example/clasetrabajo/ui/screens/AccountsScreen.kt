package com.example.clasetrabajo.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.clasetrabajo.data.model.AccountModel
import com.example.clasetrabajo.data.viewmodel.AccountViewModel
import com.example.clasetrabajo.ui.components.AccountCardComponent
import com.example.clasetrabajo.ui.components.TopBarComponent

@Composable
fun AccountsScreen(
    navController: NavHostController,
    viewModel: AccountViewModel = viewModel()
){
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    Column(){
        TopBarComponent(title = "Account Screen")
        //Launched effect is used to show animations and other things, in this case it will
        //be used to call the api and manage the interface updates.
        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if(response.isSuccessful){
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load accounts: ${response.code()}")
                }
            }
        }
        AccountCardComponent(1, "Name", "Username", "")
    }
}
