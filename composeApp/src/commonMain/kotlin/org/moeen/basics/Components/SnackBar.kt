package org.moeen.basics.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.moeen.basics.Components.BackButton

@Composable
fun SnackBAr(navController: NavController){
    // Add BackButton at the top
    BackButton(navController)
    
    val scope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {

            SnackbarHost(hostState = snackbarHostState)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Show Snackbar") },
                icon = { Icon(Icons.Filled.Image, contentDescription = "Image Icon") },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Snackbar",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )
                        when(result){

                            SnackbarResult.ActionPerformed->{
                                // Perform Any Action


                            }
                            SnackbarResult.Dismissed->{
                                // Dismiss Any Action
                            }
                        }
                    }
                }
            )
        },
        content = {padding->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
            ){

                Text(text = "Tab the Fab to show the Snackbar")
            }
        }

    )
}