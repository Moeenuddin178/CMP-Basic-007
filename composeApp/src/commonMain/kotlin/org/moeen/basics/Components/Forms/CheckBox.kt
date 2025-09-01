package org.moeen.basics.Components.Forms

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun CheckBoxExample(navController: NavController) {
    // Add BackButton at the top
    BackButton(navController)

    // Use mutableStateListOf to ensure recomposition
    val childCheckedStates = remember {
        mutableStateListOf(false, false, false)
    }

    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    for (i in childCheckedStates.indices) {
                        childCheckedStates[i] = newState
                    }
                }
            )
        }

        childCheckedStates.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckedStates[index] = it
                    }
                )
            }
        }

        if (childCheckedStates.all { it }) {
            Text("All options selected")
        }
    }
}