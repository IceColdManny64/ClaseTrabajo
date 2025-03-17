package com.example.clasetrabajo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.clasetrabajo.R

@Composable
fun AMScreen(navController: NavHostController){
    onTopBar()
    Column(
        modifier = Modifier
            .padding(0.dp, 60.dp, 0.dp, 0.dp)
            .fillMaxSize()
            .background(Color.Black)
    ) {
        recentP()
        recentA()
        beatlesW()
        beatlesA()
        musicBar()
        navBar()
    }
}

@Preview
@Composable

fun recentP(){
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(horizontal = 1.dp)
    ){
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = {}
        )
        {
            Text(
                stringResource(R.string.recents_text),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold)
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Show more arrow",
                tint = Color.White
            )
        }
    }
}
@Preview
@Composable
fun recentA() {
Row(
    modifier = Modifier
        .padding(top = 1.dp)
){
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        Image(
            modifier = Modifier
                .size(160.dp),
            painter = painterResource(R.drawable.nujabes),
            contentDescription = "Nujabes album titled Metaphorical Music",
            contentScale = ContentScale.Crop
        )
        Text(

            stringResource(R.string.album1_title),
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 5.dp)
        )
        Text(
            stringResource(R.string.album1_artist),
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(top = 1.dp)
        )
    }
    Box(){
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(160.dp),
                painter = painterResource(R.drawable.favs),
                contentDescription = "User favorite songs playlist",
                contentScale = ContentScale.Crop
            )
            Text(

                stringResource(R.string.fav_songs),
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
    }
    Box(){
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(160.dp),
                painter = painterResource(R.drawable.future),
                contentDescription = "1999 WRITE THE FUTURE album titled hella",
                contentScale = ContentScale.Crop
            )
            Text(
                "h",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
            Text(
                "1",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 1.dp)
            )

        }
    }
    }
}
@Preview
@Composable

fun beatlesW(){
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(horizontal = 1.dp)
    ){
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = {}
        )
        {
            Text(
                stringResource(R.string.beatles_world),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold)
        }
    }
}
@Preview
@Composable
fun beatlesA() {
    Row(
        modifier = Modifier
            .padding(top = 4.dp)
            .padding(bottom = 25.dp)
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(160.dp),
                painter = painterResource(R.drawable.getback),
                contentDescription = "The Beatles album titled Get Back",
                contentScale = ContentScale.Crop
            )
            Text(

                stringResource(R.string.album2_title),
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
            Text(
                stringResource(R.string.beatles_artist),
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 1.dp)
            )
        }
        Box(){
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(160.dp),
                    painter = painterResource(R.drawable.pleaseme),
                    contentDescription = "The Beatles album titled Please Please Me",
                    contentScale = ContentScale.Crop
                )
                Text(

                    stringResource(R.string.album3_title),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    stringResource(R.string.beatles_artist),
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 1.dp)
                )
            }
        }
        Box(){
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(160.dp),
                    painter = painterResource(R.drawable.rubber),
                    contentDescription = "The Beatles album titled Rubber Soul",
                    contentScale = ContentScale.Crop
                )
                Text(
                    "R",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    "T",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 1.dp)
                )

            }
        }
    }
}
@Preview
@Composable
fun onTopBar(){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(60.dp)
            .padding(horizontal = 10.dp)
            .drawBehind {
                val borderSize = 2.dp.toPx() // Grosor del borde
                drawRect(
                    color = Color.DarkGray,
                    topLeft = Offset(0f, size.height - borderSize),
                    size = Size(size.width, borderSize)
                )
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(R.string.screen_title),
            color = Color.White,
            fontSize = 20.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.cast_foreground),
                contentDescription = "Cast Icon",
                tint = Color.Red,
                modifier = Modifier
            )
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = "Menu Icon",
                tint = Color.Red,
                modifier = Modifier
                    .size(35.dp)
            )
        }
    }
}

@Preview
@Composable
fun musicBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.bargray))
            .height(60.dp)
            .padding(horizontal = 10.dp)
            .drawBehind {
                val borderSize = 2.dp.toPx() // Grosor del borde
                drawRect(
                    color = Color.DarkGray,
                    topLeft = Offset(0f, size.height - borderSize),
                    size = Size(size.width, borderSize)
                )
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Image(
            modifier = Modifier
                .padding(horizontal = 1.dp)
                .size(50.dp),
            painter = painterResource(R.drawable.nujabes),
            contentDescription = "Nujabes album titled Metaphorical Music",
            contentScale = ContentScale.Inside

        )
        Text(
            modifier = Modifier
                .padding(horizontal = 3.dp),
            text = stringResource(R.string.song1_title),
            color = Color.White,
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 1.dp),
            text = stringResource(R.string.song1_title),
            color = colorResource(R.color.bargray),
            fontSize = 15.sp
        )
            Icon(
                Icons.Filled.PlayArrow,
                contentDescription = "Play music button",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
            )
            Icon(
                painter = painterResource(R.drawable.fforward_foreground),
                contentDescription = "Next song Button",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
            )

    }

}
@Preview
@Composable
fun navBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.bargray))
            .height(60.dp)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                Icons.Filled.Home,
                contentDescription = "Home button",
                tint = Color.Red,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 7.dp)
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "Inicio",
                color = Color.Red,
                fontSize = 15.sp
            )
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = painterResource(R.drawable.dashbo_foreground),
                contentDescription = "Explore button",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(44.dp)
            )
            Text(
                modifier = Modifier,
                text = "Novedades",
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = painterResource(R.drawable.radioc_foreground),
                contentDescription = "Radio button",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(44.dp)
            )
            Text(
                modifier = Modifier,
                text = "Radio",
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = painterResource(R.drawable.librarym_foreground),
                contentDescription = "Music library button",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(44.dp)
            )
            Text(
                modifier = Modifier,
                text = "Biblioteca",
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search button",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 7.dp)
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "Buscar",
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
        }
    }
