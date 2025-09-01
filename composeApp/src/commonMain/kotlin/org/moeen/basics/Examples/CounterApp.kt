package org.moeen.basics.Examples

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun CounterAppScreen(navController: NavController) {
    var count by remember { mutableStateOf(0) }
    
    // Animation for the counter text scale
    val scale by animateFloatAsState(
        targetValue = if (count > 0) 1.1f else 1f,
        animationSpec = spring(dampingRatio = 0.5f),
        label = "counterScale"
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            BackButton(navController = navController)
        }
        
        // Screen title
        Text(
            text = "Animated Counter App",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            textAlign = TextAlign.Center
        )
        
        // Counter display with animation
        Text(
            text = "$count",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .scale(scale)
                .padding(vertical = 32.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Control buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Decrement button with animation
            AnimatedButton(
                onClick = {
                    if (count > 0) {
                        count--
                    }
                },
                icon = Icons.Default.Remove,
                color = Color(0xFFD32F2F),
                contentDescription = "Decrement"
            )
            
            // Reset button
            Button(
                onClick = {
                    count = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text("Reset")
            }
            
            // Increment button with animation
            AnimatedButton(
                onClick = {
                    count++
                },
                icon = Icons.Default.Add,
                color = Color(0xFF388E3C),
                contentDescription = "Increment"
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Additional info
        Text(
            text = "Tap buttons to animate the counter",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AnimatedButton(
    onClick: () -> Unit,
    icon: ImageVector,
    color: Color,
    contentDescription: String
) {
    var isPressed by remember { mutableStateOf(false) }
    
    // Scale animation for button press
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = tween(
            durationMillis = 100,
            easing = FastOutSlowInEasing
        ),
        label = "buttonScale"
    )
    
    Box(
        modifier = Modifier
            .size(64.dp)
            .scale(scale)
            .background(
                color = color,
                shape = CircleShape
            )
            .clickable(
                onClick = onClick
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}