package com.kmm.kmm_course.`2_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController

@Composable
fun RainbowText(navController: NavController) {

    val rainbowColors = listOf(
        Color.Blue,
        Color.Cyan,
        Color.Yellow,
        Color.Green,
        Color.Cyan,
        Color.Magenta,
    )
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("Do not allow people to dim your shine \n ")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {

                    append("because they are blinded.")

                }
                append("\n tell them to put some sunglasses on")
            }
        )
    }
    Button(
        onClick = {navController.popBackStack()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }


}
