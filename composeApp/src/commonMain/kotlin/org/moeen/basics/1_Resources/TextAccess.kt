package com.kmm.kmm_course.`1_Resources`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cmp_basic_007.composeapp.generated.resources.Fruit
import cmp_basic_007.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.moeen.basics.theme.Orange


@Composable
fun TextAccees(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Text(text = stringResource(Res.string.Fruit), fontSize = 40.sp, color = Orange)

    }
    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "← Back to Home")
    }

}




