package com.example.clasetrabajo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.clasetrabajo.R

@Composable
fun AccountDetailCardComponent(
    id:Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit
){
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            Arrangement.Absolute.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

        ) {
            AsyncImage(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                model = imageURL,
                contentScale = ContentScale.FillBounds,
                contentDescription = "Account logo",
                error = painterResource(R.drawable.audi),
            )
            Row (

            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(modifier = Modifier.padding(10.dp),
                    text= name,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold)
                Text(modifier = Modifier.padding(1.dp),
                    text= username,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
                Text(modifier = Modifier.padding(1.dp),
                    text= password,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
                Text(modifier = Modifier.padding(1.dp),
                    text= description,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
                IconButton(
                    modifier = Modifier
                        .padding(20.dp, 0.dp, 0.dp, 0.dp)
                        .background(MaterialTheme.colorScheme.secondary),
                    onClick = {
                        onSaveClick()
                    },
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                    Text(text = "Save as favorite", textAlign = TextAlign.Center)
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "Add")
                    }
                }
            }
            }
        }
    }
}
