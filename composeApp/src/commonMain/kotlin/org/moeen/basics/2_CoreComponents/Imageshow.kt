package org.moeen.basics.`2_CoreComponents`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.news
import org.jetbrains.compose.resources.painterResource

@Composable
fun Imageshow(navController: NavController) {


    val rainbowColors = remember {

        Brush.sweepGradient(
            listOf(
                Color.Red,
                Color.Cyan,
                Color.Yellow,
                Color.Green,
            )
        )
    }

    val borderWidth = 4.dp


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(Res.drawable.news),
            contentDescription = "this is news image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(300.dp).border(

                BorderStroke(borderWidth, rainbowColors)
            ),
            alignment = Alignment.Center,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {

                setToSaturation(0f)
            })
        )


    }

    Button(
        onClick = {navController.popBackStack()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }
}





