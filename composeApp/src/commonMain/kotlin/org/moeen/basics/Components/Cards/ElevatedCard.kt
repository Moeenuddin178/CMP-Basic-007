package org.moeen.basics.Components.Cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun ElevatedCard(navController: NavController){
    // Add BackButton at the top
    BackButton(navController)

    Box(
      modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){

        androidx.compose.material3.ElevatedCard(

            elevation = CardDefaults.cardElevation(
                10.dp
            ),
            modifier = Modifier.size(width = 200.dp, height = 100.dp)

        ) {
            Text("this is the elevated card",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

        }


    }
}