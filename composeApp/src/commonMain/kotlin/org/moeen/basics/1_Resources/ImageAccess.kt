package com.kmm.kmm_course.`1_Resources`

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.codeview
import cmp_basic_007.composeapp.generated.resources.ic_cyclone
import cmp_basic_007.composeapp.generated.resources.ic_rotate_right
import cmp_basic_007.composeapp.generated.resources.news
import org.jetbrains.compose.resources.painterResource
import org.moeen.basics.Components.BackButton
import org.moeen.basics.Components.Dialogs.DialogWithImage
import org.moeen.basics.Components.Dialogs.ZoomableImageDialog


@Composable
fun AccessImage(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Text("Load Image From Asset")

        Image(
            painter = painterResource(Res.drawable.ic_cyclone),
            contentDescription = "code Image",
            modifier = Modifier
                .size(200.dp) // Optional: control size
        )
        Button(
            onClick = { showDialog = true },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                //.height(56.dp)
                .padding(vertical = 16.dp)
                .shadow(4.dp, shape = RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50), // Green tone
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
        ) {
            Text(
                text = "View Code",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        if (showDialog) {
            ZoomableImageDialog(
                painterResource(resource = Res.drawable.codeview),
                onDismiss = { showDialog = false }
            )
        }


    }
    //back
    BackButton(navController)


}




