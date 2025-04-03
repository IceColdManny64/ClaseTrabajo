package com.example.clasetrabajo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.clasetrabajo.R

@Composable
fun AccountDetailCardComponent(
    id:Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String
){
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            Arrangement.Absolute.SpaceBetween,
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
        }
    }
}
