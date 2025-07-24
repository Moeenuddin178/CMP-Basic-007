package com.kmm.kmm_course.`1_Resources`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.news
import org.jetbrains.compose.resources.painterResource
import org.moeen.basics.dumy.DialogWithImage


@Composable
fun AccessImage(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Image(
            painter = painterResource(Res.drawable.news),
            contentDescription = "News Image",
            modifier = Modifier
                .size(150.dp).align(Alignment.Center)

        )




    }

    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }
}




