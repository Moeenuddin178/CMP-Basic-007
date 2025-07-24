package com.kmm.kmm_course.`2_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import org.moeen.basics.Navigation.Routes


@Composable
fun BorderOutlined(navController: NavController) {

    var text by remember {

        mutableStateOf("")
    }
    val rainbowcolors = listOf(

        Color.Red,
        Color.Cyan,
        Color.Yellow,
        Color.Green,
        Color.Blue,
    )

    val brush = remember {

        Brush.linearGradient(
            colors = rainbowcolors
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        TextField(

            value = text, onValueChange = {
                text = it
            },
            textStyle = TextStyle(brush = brush)
        )

    }
    Button(
        onClick = {navController.popBackStack()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }

}

