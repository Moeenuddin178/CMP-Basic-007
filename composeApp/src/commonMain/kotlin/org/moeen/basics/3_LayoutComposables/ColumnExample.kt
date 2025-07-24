package org.moeen.basics.`3_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// 1. Column, it allows you to place its children in a vertical sequence.

@Composable
fun ColumnExample(navController: NavController) {

    Column {
        Button(
            onClick = {navController.popBackStack()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "← Back to Home")
        }
        Column(

            modifier = Modifier.fillMaxWidth()
                .padding(0.dp, 30.dp)
                .background(Color.Blue)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("text 1")
            Text("text 2")
            Text("text 3")
            Text("text 4")
            Text("text 5")

        }


    }
}