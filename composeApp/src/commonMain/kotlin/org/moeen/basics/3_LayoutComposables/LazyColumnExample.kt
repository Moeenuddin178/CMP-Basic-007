package org.moeen.basics.`3_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun LazyColumnExample(navController: NavController) {

    Column {
        BackButton(navController)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text("LazyColumn (prefered for the lists")

            LazyColumn(

                modifier = Modifier.fillMaxWidth()
                    .background(Color.LightGray)
            ) {

                items(100) { index ->

                    Text(
                        text = "Item $index in LazyColumn",
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                            .background(Color.White)
                    )

                }
            }


        }
    }


}