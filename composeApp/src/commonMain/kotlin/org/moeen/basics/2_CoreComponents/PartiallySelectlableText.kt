package com.kmm.kmm_course.`2_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun PartiallySelectlableText(navController: NavController) {
      BackButton(navController)
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        SelectionContainer {

            Column {


                Text("This is a text can be select")
                Text("this one too")
                Text("this is the third")
                DisableSelection {

                    Text("this is not selectable one")
                    Text("this is not selectable text")

                }
            }
        }


    }
}