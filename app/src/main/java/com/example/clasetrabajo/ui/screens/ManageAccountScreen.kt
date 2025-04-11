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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.clasetrabajo.data.model.AccountModel
import com.example.clasetrabajo.data.viewmodel.AccountViewModel
import com.example.clasetrabajo.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    accountId: Int? = null, // 👈 Esto indica si viene de editar
    viewModel: AccountViewModel = viewModel()
){
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    // Si accountId no es nulo, cargamos la cuenta para editar
    LaunchedEffect(accountId) {
        accountId?.let {
            viewModel.getAccount(it) { response ->
                if (response.isSuccessful) {
                    account.value = response.body() ?: AccountModel()
                } else {
                    Toast.makeText(context, "Error loading account", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ){
        TopBarComponent("Add/Update Account", navController, "manageAcScreen")

        // Campos
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.name,
            onValueChange = { account.value = account.value.copy(name = it) },
            label = { Text("Account Name") }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.username,
            onValueChange = { account.value = account.value.copy(username = it) },
            label = { Text("Account Username") }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.password,
            onValueChange = { account.value = account.value.copy(password = it) },
            label = { Text("Account Password") }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.description,
            onValueChange = { account.value = account.value.copy(description = it) },
            label = { Text("Account Description") }
        )
        FilledTonalButton(
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            onClick = {
                TryCreateAccount(account, context, viewModel, accountId)
            }
        ){
            Text("Save Account")
        }
    }
}

fun TryCreateAccount(
    accountState: MutableState<AccountModel>,
    context: Context,
    viewModel: AccountViewModel,
    accountId: Int? // 👈 aquí usamos esto para decidir
){
    val acc = accountState.value

    if (
        acc.name.isEmpty() ||
        acc.username.isEmpty() ||
        acc.password.isEmpty() ||
        acc.description.isEmpty()
    ) {
        Toast.makeText(context, "None of the fields can be empty", Toast.LENGTH_SHORT).show()
        return
    }

    if (accountId == null) {
        // Crear cuenta
        viewModel.createAccount(acc) { jsonResponse ->
            val createAcStatus = jsonResponse?.get("store")?.asString
            if (createAcStatus == "success") {
                Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error creating account", Toast.LENGTH_SHORT).show()
            }
        }
    } else {
        // Actualizar cuenta
        viewModel.updateAccount(accountId, acc) { jsonResponse ->
            val updateAcStatus = jsonResponse?.get("update")?.asString
            if (updateAcStatus == "success") {
                Toast.makeText(context, "Account updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error updating account", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
