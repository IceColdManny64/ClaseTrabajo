package com.example.clasetrabajo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Column() {
                    Column(){
                        TextComposable("Carlos")
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Row(){
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Column(){
                        ModifierExample1()
                        ModifierExample2()
                        ModifierExample3()
                    }
                }
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name:String = "Empty"){
        Text(text = "Welcome")
        Text(name)
    }

    @Preview(showBackground = true)
    @Composable
    fun ModifierExample1(){
        Column(
            modifier = Modifier
                //Left, Top, Right, Bottom
                .padding(40.dp, 30.dp, 20.dp, 10.dp)
        ){
            Text("Hello World")
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample2(){
        Column(
            modifier = Modifier
                //Left, Top, Right, Bottom
                .padding(40.dp, 30.dp, 20.dp, 10.dp)
                //use 100% of the device width, height, or both
                .fillMaxWidth()
                .clickable(onClick = {clickAction()})
        ){
            Text("Hello World")
        }
    }
    fun clickAction(){
        println("Column clicked")
    }

    @Preview(showBackground = true)
    @Composable
    fun ModifierExample3(){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Green)
                .border(width = 2.dp, color = Color.Magenta)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            //Use all of the available space in the screen evenly
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            TextComposable("1")
            TextComposable("2")
            TextComposable("3")
            TextComposable("4")

        }
    }
}

