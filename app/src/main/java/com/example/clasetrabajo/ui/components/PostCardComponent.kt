package com.example.clasetrabajo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clasetrabajo.R

@Composable
fun PostCardComponent(id:Int, title:String, text:String, image:Int){
    Card(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(5.dp)

    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(image),
            contentDescription = "Audi TTS",
            contentScale = ContentScale.Crop
        )
        Text(
            //text = stringResource(R.string.lorem),
            text = text,
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier.padding(10.dp)
        )

    }
}
@Composable
fun PostCardCompactComponent(id:Int, title:String, text:String, image:Int) {
    Card(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp)
                    .size(100.dp)
                    .height(200.dp),
                painter = painterResource(image),
                contentDescription = "Audi TTS",
                contentScale = ContentScale.Crop,

                )

            Column() {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = text,
                    textAlign = TextAlign.Left,
                    lineHeight = 14.sp,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}