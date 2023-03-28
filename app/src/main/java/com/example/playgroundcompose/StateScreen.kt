package com.example.playgroundcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.random.Random

@Destination
@Composable
fun StatesScreen() {
    Column(Modifier.fillMaxSize()) {
        ColorBox(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )
        Spacer(modifier = Modifier.size(2.dp))
        ColorBox(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }
}


@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember { mutableStateOf(Yellow) }
    val counter = remember { mutableStateOf(1) }


    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                if (counter.value < 20) {
                    counter.value = counter.value + 1
                    color.value = Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                }
            },
        contentAlignment = Center
    ) {
        Text(text = counter.value.toString(), fontSize = 20.sp)
    }
}