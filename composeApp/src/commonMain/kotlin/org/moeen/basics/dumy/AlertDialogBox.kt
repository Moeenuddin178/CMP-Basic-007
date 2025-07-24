package org.moeen.basics.dumy


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.news
import org.jetbrains.compose.resources.painterResource


@Composable
fun DialogWithImage(


    ) {

    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Show Dialog")
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = {
                showDialog = false
            }

        ) {
            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Image(
                    painter = painterResource(Res.drawable.news),
                    contentDescription = "this is dialog image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp).fillMaxWidth()


                )
                Text(
                    text = "this is the dialog",
                    modifier = Modifier.padding(16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = {
                            showDialog = false
                        },
                        modifier = Modifier.padding(8.dp)


                    ) {
                        Text("Confirm")

                    }

                    TextButton(
                        onClick = {
                            showDialog = false
                        },
                        modifier = Modifier.padding(8.dp)


                    ) {
                        Text("Dismiss")

                    }

                }
            }

        }
    }




}


