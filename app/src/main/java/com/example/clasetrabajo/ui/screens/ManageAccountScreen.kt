package com.example.clasetrabajo.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.clasetrabajo.data.model.AccountModel
import com.example.clasetrabajo.data.model.UserModel
import com.example.clasetrabajo.data.viewmodel.AccountViewModel
import com.example.clasetrabajo.data.viewmodel.UserViewModel
import com.example.clasetrabajo.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
){
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ){
        TopBarComponent("Add Account", navController, "manageAcScreen")

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            onValueChange = {account.value = account.value.copy(name = it)},
            label = {Text("Account Name")},
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            onValueChange = {account.value = account.value.copy(username = it)},
            label = {Text("Account Username")},
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            onValueChange = {account.value = account.value.copy(password = it)},
            label = {Text("Account Password")},
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            onValueChange = {account.value = account.value.copy(description = it)},
            label = {Text("Account Description")},
        )
        FilledTonalButton(
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            onClick = {
//                TryCreateAccount(user, username, password, description, context, ViewModel)
            }
        ){
            Text("Save Account")
        }
    }
}
//fun TryCreateAccount(
//    user:String,
//    username:String,
//    password:String,
//    description:String,
//    context: Context,
//    viewModel: UserViewModel
//){
//    if(user == "" || password == ""){
//        //requires a context
//        Toast.makeText(
//            //will show a message only when both user and password are empty
//            context,
//            "User or password cannot be empty",
//            Toast.LENGTH_SHORT //the message will show for a shorter timespan
//        ).show()
//    } else {
//        val user_model = UserModel(0, "", user, password)
//        viewModel.loginAPI(user_model){ jsonResponse ->
//            val loginStatus = jsonResponse?.get("login")?.asString
//            Log.d("debug", "LOGIN STATUS: $loginStatus")
//            if(loginStatus == "success"){
//                navController.nav
//                igate("accountsScreen")
//            }
//        }
//  }
//}