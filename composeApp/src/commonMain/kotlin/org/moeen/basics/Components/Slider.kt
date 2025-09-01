package org.moeen.basics.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun Slider(navController: NavController){

    // Add BackButton at the top
    BackButton(navController)
    
    var sliderposition by remember {
        mutableStateOf(0f)
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Slider(
            value = sliderposition,
            onValueChange = {sliderposition  = it},
            colors  = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTickColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            steps = 10,
            valueRange = 0f..50f
        )
        Text(text = sliderposition.toString())
    }
}