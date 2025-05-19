package com.example.clasetrabajo

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.clasetrabajo.data.database.AppDatabase
import com.example.clasetrabajo.data.database.DatabaseProvider
import com.example.clasetrabajo.ui.screens.AMScreen
import com.example.clasetrabajo.ui.screens.AccountsScreen
import com.example.clasetrabajo.ui.screens.Calendar
import com.example.clasetrabajo.ui.screens.Camera
import com.example.clasetrabajo.ui.screens.ComponentsScreen
import com.example.clasetrabajo.ui.screens.FavoriteAccountsScreen
import com.example.clasetrabajo.ui.screens.HomeScreen
import com.example.clasetrabajo.ui.screens.LoginScreen
import com.example.clasetrabajo.ui.screens.MainMenuScreen
import com.example.clasetrabajo.ui.screens.ManageAccountScreen
import com.example.clasetrabajo.ui.screens.NotificationScreen
import com.example.clasetrabajo.ui.screens.TestScreen
import com.example.clasetrabajo.ui.screens.TryCreateAccount
import com.example.clasetrabajo.ui.theme.ClaseTrabajoTheme

class MainActivity : ComponentActivity() {
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to program in the entire screen
        //enableEdgeToEdge()

        try{
            database = DatabaseProvider.getDatabase(this)
            Log.d("debug-db", "DATABASE LOADED SUCCESSFULLY" )
        }catch (exception: Exception){
            Log.d("debug-db", "ERROR: $exception" )
        }

        //screen interface content
        setContent {

            //theme function
            ClaseTrabajoTheme {
                ComposeMultiScreenApp()
            }
        }
    }

}//Close class
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
        composable("manageAcScreen") { ManageAccountScreen(navController = navController) }
        composable(
            route = "notifScreen",
            deepLinks = listOf(navDeepLink { uriPattern = "app://notificacion" })
        ) {
            NotificationScreen(navController)
        }

        composable(
                route = "manageAcScreen/{id}",
        arguments = listOf(navArgument("id") { defaultValue = -1 })
        ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
        ManageAccountScreen(
            navController = navController,
            accountId = id // <-- aquí es importante nombrarlo
        )
    }
        composable("favAcScreen"){ FavoriteAccountsScreen(navController) }
        composable("camScreen") { Camera(navController) }
        composable("calScreen") {Calendar(navController)}
        }
    }

