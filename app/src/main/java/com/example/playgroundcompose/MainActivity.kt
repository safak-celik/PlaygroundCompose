package com.example.playgroundcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playgroundcompose.destinations.*
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}

@Destination(start = true)
@Composable
fun Buttons(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navigator.navigate(ImagesDestination)
        }
        ) {
            Text(text = "Navigate to  ${ImagesDestination.route}")
        }
        Button(onClick = { navigator.navigate(AnimationsDestination) }) {
            Text(text = "Navigate to  ${AnimationsDestination.route}")
        }
        Button(onClick = { navigator.navigate(ConstraintsDestination) }) {
            Text(text = "Navigate to  ${ConstraintsDestination.route}")
        }
        Button(onClick = { navigator.navigate(ShoppingCardsDestination) }) {
            Text(text = "Navigate to  ${ShoppingCardsDestination.route}")
        }
        Button(onClick = { navigator.navigate(StatesScreenDestination) }) {
            Text(text = "Navigate to ${StatesScreenDestination.route}")
        }
        Button(onClick = { navigator.navigate(InstagramScreenDestination) }) {
            Text(text = "Navigate to ${InstagramScreenDestination.route}")
        }
    }
}
