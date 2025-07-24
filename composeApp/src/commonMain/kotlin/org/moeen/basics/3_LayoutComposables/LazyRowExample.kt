package org.moeen.basics.`3_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LazyRowExample(navController: NavController) {

    Button(
        onClick = {navController.popBackStack()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }
    Column(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("LazyRow (prefered for the lists")

        LazyRow(

            modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray)
        ) {

            items(100) { index->

                Text(
                    text = "Item $index in LazyColumn",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .background(Color.White)
                )

            }
        }


    }


}