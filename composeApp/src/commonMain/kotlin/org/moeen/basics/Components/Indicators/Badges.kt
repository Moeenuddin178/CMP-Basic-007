package org.moeen.basics.Components.Indicators

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Badge(navController: NavController){
    // Add BackButton at the top
    BackButton(navController)
    
    var itemCount by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        BadgedBox(
            badge = {

                if(itemCount >0 ){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text("$itemCount")

                    }
                }
            }
        ) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Filled.ShoppingCart,
                contentDescription = "Add"
            )

        }
        Button(
            onClick = {
                itemCount++
            }
        ) {
            Text("Add item")
        }
    }

}