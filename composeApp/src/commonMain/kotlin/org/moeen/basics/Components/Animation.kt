package org.moeen.basics.Components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun AnimatedBox(navController: NavController) {
    // Add BackButton at the top
    BackButton(navController)
    
    var expanded by remember {
        mutableStateOf(false)
    }

    val size by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,
        animationSpec = tween(

            durationMillis = 500,
            easing = FastOutSlowInEasing

        ),
        label = "BoxSizeAmination"
    )

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Blue)
                .clickable {
                    expanded = !expanded
                },
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Tap Me",
                color = Color.White,
                fontWeight = FontWeight.Bold

            )
        }
    }


}