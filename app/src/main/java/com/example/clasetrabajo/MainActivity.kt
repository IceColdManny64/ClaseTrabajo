package com.example.clasetrabajo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clasetrabajo.ui.screens.AMScreen
import com.example.clasetrabajo.ui.screens.AccountsScreen
import com.example.clasetrabajo.ui.screens.ComponentsScreen
import com.example.clasetrabajo.ui.screens.HomeScreen
import com.example.clasetrabajo.ui.screens.LoginScreen
import com.example.clasetrabajo.ui.screens.MainMenuScreen
import com.example.clasetrabajo.ui.screens.TestScreen
import com.example.clasetrabajo.ui.theme.ClaseTrabajoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to program in the entire screen
        //enableEdgeToEdge()

        //screen interface content
        setContent {

            //theme function
            ClaseTrabajoTheme {
                ComposeMultiScreenApp()
            }
        }
    }

} //Close class
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}
@Composable
fun SetupNavGraph(navController: NavHostController){
    //startDestinations marks which screen is going to open at launch
    NavHost(navController = navController, startDestination = "mainMenu"){
        //add route name for every screen
        composable("mainMenu"){ MainMenuScreen(navController) }
        composable("homeScreen") {HomeScreen(navController) }
        composable("testScreen") {TestScreen(navController) }
        composable("amScreen") { AMScreen(navController) }
        composable("componentsScreen") { ComponentsScreen(navController) }
        composable("loginScreen") { LoginScreen(navController) }
        composable("accountsScreen"){ AccountsScreen(navController) }
        }
    }

