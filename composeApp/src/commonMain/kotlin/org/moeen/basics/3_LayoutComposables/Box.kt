package org.moeen.basics.`3_LayoutComposables`

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

// 3. Box
@Composable
fun BoxExample(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {


        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "← Back to Home")
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center,


            ) {


            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.Black)
            ) {

            }
        }
    }

}