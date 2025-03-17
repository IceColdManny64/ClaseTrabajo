package com.example.clasetrabajo.ui.screens

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.BikeScooter
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CarRental
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NordicWalking
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.clasetrabajo.R
import com.example.clasetrabajo.data.model.MenuModel
import com.example.clasetrabajo.data.model.PostCardModel
import com.example.clasetrabajo.ui.components.PostCardCompactComponent
import com.example.clasetrabajo.ui.components.PostCardComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date


@Composable
fun ComponentsScreen(navController: NavHostController) {

    val menuOptions = arrayOf(
        MenuModel(1, "Buttons", "buttons", Icons.Filled.AddCircle),
        MenuModel(2, "Floating Buttons", "fbuttons", Icons.Filled.AccountCircle),
        MenuModel(3, "Progress", "prog", Icons.Filled.Refresh),
        MenuModel(4, "Chips", "chips", Icons.Filled.AccountBox),
        MenuModel(5, "Sliders", "slide", Icons.Filled.PlayArrow),
        MenuModel(6, "Switches", "switch", Icons.Filled.Check),
        MenuModel(7, "Badges", "badges", Icons.Filled.ShoppingCart),
        MenuModel(8, "Snack Bars", "snack", Icons.Filled.Lock),
        MenuModel(9, "Alert Dialogs", "alert", Icons.Filled.Warning),
        MenuModel(10, "Top app bar", "bar", Icons.Filled.Search),
        MenuModel(11, "Input fields", "input", Icons.Filled.Create),
        MenuModel(12, "Docked date picker", "datedocked", Icons.Filled.DateRange),
        MenuModel(13, "Field to modal date picker", "fieldmod", Icons.Filled.DateRange),
        MenuModel(14, "Date picker modal input", "dateinp", Icons.Filled.DateRange),
        MenuModel(15, "Modal date range picker", "daterange", Icons.Filled.DateRange),
        MenuModel(16, "Bottom Sheets", "sheet", Icons.Filled.ArtTrack),
        MenuModel(17, "Segmented Buttons", "segbuttons", Icons.Filled.Menu)
    )

    var option by rememberSaveable { mutableStateOf("bar") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
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
        when (option) {
            "buttons" -> {
                Buttons()
            }

            "fbuttons" -> {
                FloatingButtons()
            }

            "prog" -> {
                Progress()
            }

            "chips" -> {
                Chips()
            }

            "slide" -> {
                Sliders()
            }

            "switch" -> {
                Switches()
            }

            "badges" -> {
                Badges()
            }

            "snack" -> {
                SnackBars()
            }

            "alert" -> {
                AlertDialogs()
            }

            "bar" -> {
                Bars()
            }

            "input" -> {
                InputFields()
            }

            "datedocked" -> {
                DatePickerDockedComposable()
            }

            "fieldmod" -> {
                DatePickerFieldToModalComposable()
            }

            "dateinp" -> {
                DatePickerModalInputComposable()
            }

            "daterange" -> {
                DateRangePickerModalComposable()
            }

            "sheet" -> {
                BottomSheets()
            }

            "segbuttons" -> {
                SegmentedButtons()
            }


        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Buttons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
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
fun FloatingButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
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
fun Progress() {
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
            onClick = { selected = !selected },
            label = { Text("Filter Chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
        InputChipExample("Dismiss", {})

    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
    InputChip(
        label = { Text(text) },
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
fun Sliders() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            //updates the slider state according to the users interaction with it
            onValueChange = { SliderPosition = it },
            steps = 10,
            valueRange = 0f..100f,
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
            onCheckedChange = { checked = it },
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = { checked2 = it },
            //adding an icon that will show only when the switch is active
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Check Switch",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = { checked3 = it }
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
                if (itemCount > 0) {
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
            onClick = { itemCount++ }
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

        fun launchSnackBar() {
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }
        //invoking the previous function in a shorter way
        Button(::launchSnackBar) {
            Text("Send Message")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
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
        if (showAlertDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Info, contentDescription = "Info Icon") },
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
        Button(onClick = { showAlertDialog = true }) {
            Text("Delete File")
        }
        Text(selectedOption)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun Bars() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //can use MediumTopAppBar and other similar components to change the top bar size.
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = { Text("Screen Title") },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Button")
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings Button"
                    )
                }
            }
        )

//        val arrayPosts = arrayOf(
//            PostCardModel(1, "Title 1", "Text 1", R.drawable.nujabes),
//            PostCardModel(2, "Title 2", "Text 2", R.drawable.nujabes),
//            PostCardModel(3, "Title 3", "Text 3", R.drawable.nujabes),
//            PostCardModel(4, "Title 1", "Text 1", R.drawable.nujabes),
//            PostCardModel(5, "Title 2", "Text 2", R.drawable.nujabes),
//            PostCardModel(6, "Title 3", "Text 3", R.drawable.nujabes),
//            PostCardModel(7, "Title 1", "Text 1", R.drawable.nujabes),
//            PostCardModel(8, "Title 2", "Text 2", R.drawable.nujabes),
//            PostCardModel(9, "Title 3", "Text 3", R.drawable.nujabes)
//        )
//        //can use Lazy Row to do the same but in a horizontal layout
//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 100.dp),
//            modifier = Modifier
//                .fillMaxSize()
//                //the 1f value in the .weight modifier is used to spread the components evenly
//                .weight(1f)
//        ) {
//            items(arrayPosts){
//                item -> PostCardComponent(item.id, item.title, item.text, item.image)
//            }
//        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Adaptive()
        }
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Adaptive() {
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    val originalArrayPost = arrayOf(
        PostCardModel(1, "Title 1", "Text 1", R.drawable.nujabes),
        PostCardModel(2, "Title 2", "Text 2", R.drawable.nujabes),
        PostCardModel(3, "Title 3", "Text 3", R.drawable.nujabes),
        PostCardModel(4, "Title 1", "Text 1", R.drawable.nujabes),
        PostCardModel(5, "Title 2", "Text 2", R.drawable.nujabes),
        PostCardModel(6, "Title 3", "Text 3", R.drawable.nujabes),
        PostCardModel(7, "Title 1", "Text 1", R.drawable.nujabes),
        PostCardModel(8, "Title 2", "Text 2", R.drawable.nujabes),
        PostCardModel(9, "Title 3", "Text 3", R.drawable.nujabes)
    )

    val arrayPost = remember { mutableStateOf(originalArrayPost) } // Usamos mutableStateOf

    val refreshing = remember { mutableStateOf(false) }
    val refreshScope = rememberCoroutineScope()

    fun refresh() = refreshScope.launch {
        refreshing.value = true
        delay(1500) // Simulating a network request

        // Simulating a data update by changing the title and text elements of each item
        val updatedArray = originalArrayPost.map {
            it.copy(title = "${it.title} (Refreshed)", text = "${it.text} (Refreshed)")
        }.toTypedArray()
        // Updated array
        arrayPost.value = updatedArray

        refreshing.value = false
    }

    val state = rememberPullRefreshState(refreshing.value, ::refresh)

    Column {
        if (width == WindowWidthSizeClass.COMPACT) {
            Box(Modifier.pullRefresh(state)) {
                Column {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 100.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        items(arrayPost.value) { item -> // Usamos arrayPost.value
                            PostCardComponent(item.id, item.title, item.text, item.image)
                        }
                    }
                }
                PullRefreshIndicator(refreshing.value, state, Modifier.align(Alignment.TopCenter))
            }

        } else if (height == WindowHeightSizeClass.COMPACT) {
            Box(Modifier.pullRefresh(state)) {
                LazyColumn {
                    items(arrayPost.value) { item -> // Usamos arrayPost.value
                        PostCardCompactComponent(item.id, item.title, item.text, item.image)
                    }
                }
                PullRefreshIndicator(refreshing.value, state, Modifier.align(Alignment.TopCenter))
            }
        }
    }
}

@Composable
fun InputFields() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // declaring only one text variable will update all the text fields at the same time
        // and with the same text
        var text by remember { mutableStateOf("Write here...") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("This is a simple filled text field") }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("This is an outlined text field") }
        )
        //new var with a 3-line default text to test the maxLines parameter
        var value by remember { mutableStateOf("Hello\nWorld\nInvisible") }

        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("This is a styled text field") },
            //the max amount of lines to show in the text field at a time
            maxLines = 2,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold)
        )
        //using a linear gradient to change the text color in the TextField
        //MaterialTheme is being used and it switches the gradient style depending on the theme
        val gradientColors = listOf(
            MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.tertiary
        )
        val brush = remember {
            Brush.linearGradient(
                colors = gradientColors
            )
        }
        TextField(
            value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush),
            label = { Text("This text field has a gradient color text style") }
        )

        var password by rememberSaveable { mutableStateOf("") }

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            //to transform any text in the field into a password dot symbol
            //only works with ASCII characters
            visualTransformation = PasswordVisualTransformation(
                //mask can be used to change the symbol that will cover the password
                mask = '$',
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//will appear when the icon is clicked
//date can only be specified in the calendar, not with text
fun DatePickerDockedComposable() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB Docked") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )
        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//uses a textfield to show the date too, but it will show a modal
//date picker instead, which allows to write the date in the text field
fun DatePickerFieldToModalComposable(modifier: Modifier = Modifier) {
    var selectedDate by remember { mutableStateOf("") } // Cambiado a String
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedDate, // Usa el String directamente
        onValueChange = { },
        label = { Text("DOB Modal") },
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select date")
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(selectedDate) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        DatePickerModal(
            onDateSelected = { dateString ->
                selectedDate = dateString
                showModal = false // Cierra el modal después de la selección
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Companion function for DatePickerFieldToModalComposable function
fun DatePickerModal(
    onDateSelected: (String) -> Unit // Cambiado para recibir un String
) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedDate.isNotEmpty()) {
            Text("Fecha seleccionada: $selectedDate")
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(onClick = { showDialog = true }) {
            Text("Seleccionar fecha")
        }
    }

    if (showDialog) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        selectedDate = convertMillisToDate(millis)
                        onDateSelected(selectedDate) // Llama a la función con el String
                    }
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
//converts millis to a date string

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy")
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Modal date picker, but will start on the text date input instead of the calendar input
fun DatePickerModalInputComposable() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedDate.isNotEmpty()) {
            Text("Selected date: $selectedDate")
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(onClick = { showDialog = true }) {
            Text("Input Date")
        }
    }

    if (showDialog) {
        val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        selectedDate = convertMillisToDate(millis)
                    }
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerModalComposable() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedRange by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedRange.isNotEmpty()) {
            Text("Rango seleccionado: $selectedRange")
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(onClick = { showDialog = true }) {
            Text("Seleccionar rango de fechas")
        }
    }

    if (showDialog) {
        val dateRangePickerState = rememberDateRangePickerState()
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DateRangePicker(
                state = dateRangePickerState,
                title = {
                    Text(
                        text = "Select date range"
                    )
                },
                showModeToggle = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    var text by remember { mutableStateOf("Go on!") }
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 128.dp,
        sheetContent = {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier
                    .fillMaxWidth()
                    .height(100.dp), contentAlignment = Alignment.Center) {
                    Text("Swipe up to expand sheet")
                }
                Text("Sheet content")
                Row(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(220.dp, 60.dp),
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Write something here") }
                    )
                    Button(
                        modifier = Modifier.padding(10.dp),
                        onClick = { scope.launch { scaffoldState.bottomSheetState.partialExpand() } }
                    ) {
                        Text("Collapse")
                    }

                }
            }
        }
    ) { innerPadding ->
        //content that does not belong to the sheet
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Text("Scaffold Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButtons(modifier: Modifier = Modifier) {
    val selectedOptions = remember {
        mutableStateListOf(false, false, false, false, false)
    }
    val mOptions = listOf("Walk", "Ride", "Drive", "Shop", "Locked")
    var selectedIndex by remember { mutableIntStateOf(0) }
    val sOptions = listOf("Day", "Month", "Week")
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

// allows to select one element at a time
        SingleChoiceSegmentedButtonRow {
            sOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = sOptions.size
                    ),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex,
                    label = { Text(label) }
                )
            }
        }

        //allows to select up to 5 elements at a time
        //for more complex situations, it's better to use chips
        MultiChoiceSegmentedButtonRow {
            mOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = mOptions.size
                    ),
                    checked = selectedOptions[index],
                    onCheckedChange = {
                        selectedOptions[index] = !selectedOptions[index]
                    },
                    icon = { SegmentedButtonDefaults.Icon(selectedOptions[index]) },
                    label = {
                        when (label) {
                            "Walk" -> Icon(
                                imageVector =
                                    Icons.Filled.NordicWalking,
                                contentDescription = "Directions Walk"
                            )

                            "Ride" -> Icon(
                                imageVector =
                                    Icons.Default.BikeScooter,
                                contentDescription = "Directions Bus"
                            )

                            "Drive" -> Icon(
                                imageVector =
                                    Icons.Default.CarRental,
                                contentDescription = "Directions Car"
                            )

                            "Shop" -> Icon(
                                imageVector =
                                    Icons.Filled.Shop,
                                contentDescription = "Shop"
                            )

                            "Locked" -> Icon(
                                imageVector =
                                    Icons.Filled.Lock,
                                contentDescription = "Lock"
                            )
                        }
                    }
                )
            }
        }
    }
}
