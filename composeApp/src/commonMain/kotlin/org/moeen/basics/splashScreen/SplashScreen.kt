package org.moeen.basics.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRepair
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmp_basic_007.composeapp.generated.resources.Res
import cmp_basic_007.composeapp.generated.resources.ic_rotate_right
import org.jetbrains.compose.resources.painterResource


@Composable
fun Splash1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(Res.drawable.ic_rotate_right),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("AutoUstaad", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Smart Auto Solutions", fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun Splash5() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF4CAF50), Color(0xFF81C784))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.CarRepair, contentDescription = null, tint = Color.White, modifier = Modifier.size(80.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("AutoUstaad", fontSize = 26.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

