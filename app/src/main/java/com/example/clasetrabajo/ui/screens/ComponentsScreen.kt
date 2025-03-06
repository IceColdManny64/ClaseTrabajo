package com.example.clasetrabajo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.clasetrabajo.data.model.MenuModel
import kotlinx.coroutines.launch
import java.util.logging.Filter

@Composable
fun ComponentsScreen(navController: NavHostController){

    val menuOptions = arrayOf(
        MenuModel(1, "Buttons", "buttons", Icons.Filled.AddCircle),
        MenuModel(2, "Floating Buttons", "fbuttons", Icons.Filled.AccountCircle),
        MenuModel(3, "Progress", "prog", Icons.Filled.Refresh),
        MenuModel(4, "Chips", "chips", Icons.Filled.AccountBox),
        MenuModel(5, "Sliders", "slide", Icons.Filled.PlayArrow),
        MenuModel(6, "Switches", "switch", Icons.Filled.Check),
        MenuModel(7, "Badges", "badges", Icons.Filled.ShoppingCart),
        MenuModel(8, "Snack Bars", "snack", Icons.Filled.Lock),
        MenuModel(3, "Alert Dialogs", "alert", Icons.Filled.Warning)

    )

    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet{
        Text("Menu", modifier = Modifier.padding(16.dp))
            HorizontalDivider()
            LazyColumn {
                items(menuOptions) { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = "") },
                        label = { Text(item.title) },
                        selected = false,
                        onClick = {
                            option = item.option
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                }
            }
        }
        }
    ) {
        when(option){
            "buttons" -> { Buttons() }
            "fbuttons" -> { FloatingButtons() }
            "prog" -> { Progress() }
            "chips" -> { Chips() }
            "slide" -> { Sliders() }
            "switch" -> { Switches() }
            "badges" -> { Badges() }
            "snack" -> { SnackBars() }
            "alert" -> { AlertDialogs() }
        }
    }
    }

//@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        //Button styles
        Button(onClick = {}) {
            Text("Filled")
        }

        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }

        OutlinedButton(onClick = {}) {
            Text("Outline")
        }

        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }

        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        //Extended floating action button can display a text
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
            Text("Button")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun Progress(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("AssistChip") },
            leadingIcon = {
                Icon(
                Icons.Filled.AccountBox,
                contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )
        //mutableStateOf is used to keep an element in a particular state
        //even if there's changes or updates in the interface
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            //selected defines if the button is pressed or not
            selected = selected,
            //This will switch the current state
            // of FilterChip to the opposite
            onClick = {selected = !selected},
            label = {Text("Filter Chip")},
            leadingIcon = if(selected){
                {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
            }else {
                null
            }
        )
        InputChipExample("Dismiss", {})

    }
}

@Composable
fun InputChipExample(
    text:String,
    onDismiss: () -> Unit
){
    var enabled by remember{ mutableStateOf(true) }
    if(!enabled) return
    InputChip(
        label = {Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "User Icon",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Cross Icon",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}
//@Preview
@Composable
fun Sliders(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            //updates the slider state according to the users interaction with it
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f,
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

//@Preview
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {checked = it},
        )
        var checked2 by remember{ mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            //adding an icon that will show only when the switch is active
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Check Switch",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}
//@Preview
@Composable
fun Badges() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                    {
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}
//@Preview
@Composable
fun SnackBars() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        //val = static
        //var = non static
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }
        //invoking the previous function in a shorter way
        Button(::launchSnackBar){
            Text("Send Message")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        //without "== true" statement, the conditional is checking for the var to be true
        if(showAlertDialog){
            AlertDialog(
                icon = {Icon(Icons.Filled.Info, contentDescription = "Info Icon")},
                title = { Text("Confirm Deletion") },
                text = { Text("Do you really want to delete this file?") },
                //to close the dialog when clicking any part of the screen that is not the Alert Dialog
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = {showAlertDialog = true}) {
            Text("Delete File")
        }
        Text(selectedOption)
    }
}
