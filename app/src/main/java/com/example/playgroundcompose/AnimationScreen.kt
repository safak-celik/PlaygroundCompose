package com.example.playgroundcompose

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Animations() {
    val constraints = ConstraintSet {
        val animatedBox = createRefFor("box")
        val progressBar = createRefFor("progressBar")

        constrain(animatedBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(progressBar) {
            top.linkTo(animatedBox.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        AnimatedBoxes()
        CircularProgressBars(
            percentage = 0.9f,
            number = 500
        )
    }
}


@Composable
fun AnimatedBoxes() {
    var sizeState by remember { mutableStateOf(180.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 1000,
            easing = FastOutLinearInEasing
        )
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Red,
        targetValue = Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1000),
            repeatMode = Reverse
        )
    )
    Box(
        modifier = Modifier
            .layoutId("box")
            .size(size)
            .background(color)
            .clip(shape = RoundedCornerShape(50.dp)),
        contentAlignment = Center
    ) {
        Button(onClick = {
            sizeState += 60.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}


@Composable
fun CircularProgressBars(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier
            .size(radius * 2f)
            .layoutId("progressBar"),
        contentAlignment = Center
    ) {
        // Draw own Views
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Black,
            fontSize = fontSize,
            fontWeight = Bold
        )
    }
}


