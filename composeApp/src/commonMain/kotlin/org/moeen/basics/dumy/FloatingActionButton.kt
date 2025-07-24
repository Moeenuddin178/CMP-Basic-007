package org.moeen.basics.dumy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FloatingActionButton (navController: NavController){

    Box(
        modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center

    ){

        ExtendedFloatingActionButton(
            onClick = {

            },

            content = {
                Text("this is Floating button")
            }
        )

    }

}