package com.example.playgroundcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import kotlin.random.Random

@Destination
@Composable
fun Images() {
    val painter = painterResource(id = R.drawable.example_image)
    val description = "Image"
    val title = "Standard Drink"
    ImageCard(painter = painter, contentDescription = description, title = title)
}

@Composable
@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6")
fun ImageCard(
    painter: Painter = painterResource(id = R.drawable.example_image),
    contentDescription: String = "Description",
    title: String = "Title",
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxSize(0.5f),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
    ) {
        Box(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Transparent,
                                Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                contentAlignment = BottomStart,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {
                TextView(title)
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun TextView(title: String) {
    val fontFamily = FontFamily(
        Font(R.font.raleway_medium)
    )
    // First State White
    val color = remember { mutableStateOf(Black) }

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    textDecoration = Underline,
                    fontSize = 20.sp,
                    color = color.value
                )
            ) {
                append(title.substringBefore(" "))
            }
            append(" " + title.substringAfter(" "))
        },

        modifier = Modifier
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            },
        fontSize = 16.sp,
        fontFamily = fontFamily,
        color = White,
    )
}

