package com.kmm.kmm_course.`2_CoreComponents`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.Story
import org.jetbrains.compose.resources.stringResource
import org.moeen.basics.Components.BackButton


@Composable
fun ScrollableText(navController: NavController) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {

        // Fixed Top Button
        BackButton(navController)

        // Scrollable Text
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(text = stringResource(Res.string.Story))
        }
    }


}






