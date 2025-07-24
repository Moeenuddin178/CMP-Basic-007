package com.example.newjetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


// Modifiers

// Modifiers are available in all the composables like text, button, image, column etc.

@Composable
fun ModifierExample(navController: NavController) {
    Column {
        Button(
            onClick = {navController.popBackStack()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "← Back to Home")
        }

        Box(
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
                .padding(0.dp, 30.dp)
                .background(

                    color = Color.Blue,
                ),
            contentAlignment = Alignment.Center

        ) {

            Text(
                "this is the jetpack",
                modifier = Modifier.background(Color.Yellow)
            )


        }
    }


}




