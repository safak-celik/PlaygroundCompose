package com.example.playgroundcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ShoppingCards() {
    LazyColumn() {
        items(100) {
            ShoppingCard(title = "Title $it", description = "Description $it")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShoppingCard(title: String, description: String) {
    val price = "17,99$"
    Box() {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp,
            onClick = {

            }
        ) {
            Row() {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                    contentAlignment = Center
                )
                {
                    ShoppingImage()
                }
                Column() {
                    Title(title = title)
                    Description(description = description)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = BottomEnd
                    ) {
                        Price(price = price)
                    }
                }
            }
        }
    }
}


@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    val fontFamily = FontFamily(Font(R.font.raleway_medium))
    Text(
        modifier = modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        text = title,
        fontSize = 24.sp,
        fontFamily = fontFamily,
        fontWeight = Bold,
        color = Black,
        maxLines = 1,
        textDecoration = Underline
    )
}

@Composable
fun Description(description: String) {
    val fontFamily = FontFamily(Font(R.font.raleway_medium))
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = description,
        fontSize = 18.sp,
        fontFamily = fontFamily,
        color = Black,
        maxLines = 3
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShoppingImage(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.example_image),
    contentDescription: String = "Description",
) {
    Image(
        painter = painter,
        contentScale = ContentScale.Inside,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxSize(0.4f)
            .padding(8.dp)
            // round Corner Image
            .clip(RoundedCornerShape(8.dp))
    )
}


@Composable
fun Price(price: String, modifier: Modifier = Modifier) {
    val fontFamily = FontFamily(Font(R.font.raleway_medium))
    Text(
        text = price,
        fontSize = 22.sp,
        fontFamily = fontFamily,
        color = Black,
        textDecoration = Underline,
        fontWeight = Bold,
        maxLines = 1,
        modifier = modifier.padding(8.dp)
    )
}


