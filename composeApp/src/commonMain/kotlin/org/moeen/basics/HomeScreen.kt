package org.moeen.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Navigation.Routes

@Composable
fun HomeScreen(
    navController: NavController
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "CMP Codes\uD83D\uDE80",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Routes.AccessImage) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Image from asset")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(Routes.TextAccess)}) {
            Text("Text from asset")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.BorderOutlined)}) {
            Text("Otlined Border Text Field")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.SelectableTextScreen)}) {
            Text("Selectable Text")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.PasswordViewScreen)}) {
            Text("Password view")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.RainbowTextScreen)}) {
            Text("Rainbow Text")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.ScrollableTextScreen)}) {
            Text("SCrollable Text")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.AnnotatedStringwithListenerSample)}) {
            Text("Annotated String with Listener Text")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.ShadowText)}) {
            Text("Shadow Text")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Imageshow)}) {
            Text("Image Show")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Imageshow)}) {
            Text("Image Show")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Box)}) {
            Text("Box")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Columnexample)}) {
            Text("Column")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.RowExample)}) {
            Text("Row")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.LazyColumn)}) {
            Text("Lazy Column")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.LazyRow)}) {
            Text("Lazy Row")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Modifier)}) {
            Text("Modifier")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.BottomSheet)}) {
            Text("Botoom Sheet")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate(Routes.Dialog)}) {
            Text("Alert Dialog ")
        }


    }

}