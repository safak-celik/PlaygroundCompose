package com.example.playgroundcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Constraints() {
    val constraints = ConstraintSet {
        // Create IDs for Constraints
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")

        // Create Guideline
        val guideLine = createGuidelineFromTop(0.3f)

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(guideLine)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Green)
            .layoutId("greenBox"))
        Box(modifier = Modifier
            .background(Red)
            .layoutId("redBox"))
    }
}
