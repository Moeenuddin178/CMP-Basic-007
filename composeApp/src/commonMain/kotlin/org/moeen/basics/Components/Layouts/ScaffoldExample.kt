package org.moeen.basics.Components.Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(navController: NavController){

    var presses by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {

            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.surface,
                ),
                title = { Text("Top app bar") }
            )

        },

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {

                Text(
                    text = "Bottom App Bar",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        },

        floatingActionButton = {

            FloatingActionButton(onClick = { presses++ }) {
                Text("I've been clicked $presses times")
            }

        }

    ) { innerPadding ->


        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.Yellow)
        ) {

            // Add BackButton at the top
            BackButton(navController)
            
            Text("this is the scaffold content",


                )
        }


    }



}