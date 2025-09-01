package org.moeen.basics.Examples

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import org.moeen.basics.Components.BackButton
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomComposablesScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
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
            text = "Custom Composables",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center
        )
        
        // Custom composables examples
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Animated progress indicator
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Animated Progress Indicator",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    var progress by remember { mutableStateOf(0f) }
                    AnimatedProgressIndicator(
                        progress = progress,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(16.dp)
                    )
                    
                    Button(
                        onClick = {
                            progress = if (progress >= 1f) 0f else progress + 0.1f
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Increase Progress")
                    }
                }
            }
            
            // Custom toggle switch
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Custom Toggle Switch",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    var isToggled by remember { mutableStateOf(false) }
                    CustomToggleSwitch(
                        isToggled = isToggled,
                        onToggle = { isToggled = it },
                        modifier = Modifier.padding(16.dp)
                    )
                    
                    Text(
                        text = if (isToggled) "ON" else "OFF",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            
            // Animated star rating
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Animated Star Rating",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    var rating by remember { mutableStateOf(3f) }
                    AnimatedStarRating(
                        rating = rating,
                        onRatingChange = { rating = it },
                        modifier = Modifier.padding(16.dp)
                    )
                    
                    Text(
                        text = "Rating: $rating",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            
            // Additional custom composables can be added here
            // They will now be scrollable
            for (i in 1..3) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Custom Composable $i",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        Text(
                            text = "This is an example of a scrollable custom composable component. You can add as many as needed and they will be accessible through scrolling.",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        Button(
                            onClick = { /* Handle click */ },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text("Try Me")
                        }
                    }
                }
            }
        }
        
        // Add some spacing at the bottom to ensure the last item is fully visible
        Spacer(modifier = Modifier.height(24.dp))
    }
}

// Custom animated progress indicator
@Composable
fun AnimatedProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 8.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "progressAnimation"
    )
    
    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = (size.minDimension - strokeWidth.toPx()) / 2
        val sweepAngle = 360f * animatedProgress
        
        // Background circle
        drawCircle(
            color = color.copy(alpha = 0.2f),
            radius = radius,
            center = center,
            style = Stroke(width = strokeWidth.toPx())
        )
        
        // Progress arc
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = Offset(
                center.x - radius,
                center.y - radius
            ),
            size = Size(radius * 2, radius * 2),
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}

// Custom toggle switch
@Composable
fun CustomToggleSwitch(
    isToggled: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 64.dp,
    height: Dp = 32.dp
) {
    val scale by animateFloatAsState(
        targetValue = if (isToggled) 1f else 0.9f,
        animationSpec = tween(200),
        label = "toggleScale"
    )
    
    val thumbPosition by animateFloatAsState(
        targetValue = if (isToggled) 1f else 0f,
        animationSpec = tween(200),
        label = "thumbPosition"
    )
    
    Box(
        modifier = modifier
            .size(width, height)
            .scale(scale)
            .clip(RoundedCornerShape(50))
            .background(
                if (isToggled) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = 0.5f)
            )
            .clickable { onToggle(!isToggled) }
    ) {
        Box(
            modifier = Modifier
                .size(height)
                .padding(4.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}

// Animated star rating
@Composable
fun AnimatedStarRating(
    rating: Float,
    onRatingChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
    starSize: Dp = 32.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val isPartial = i > rating && i - 1 < rating
            val partialRatio = if (isPartial) rating - (i - 1) else 0f
            
            Star(
                isSelected = isSelected,
                isPartial = isPartial,
                partialRatio = partialRatio,
                onClick = { onRatingChange(i.toFloat()) },
                size = starSize
            )
        }
    }
}

@Composable
fun Star(
    isSelected: Boolean,
    isPartial: Boolean,
    partialRatio: Float,
    onClick: () -> Unit,
    size: Dp
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.2f else 1f,
        animationSpec = tween(300),
        label = "starScale"
    )
    
    Box(
        modifier = Modifier
            .size(size)
            .scale(scale)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isPartial) {
            // Draw partial star
            PartialStar(
                partialRatio = partialRatio,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                size = size
            )
        } else {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun PartialStar(
    partialRatio: Float,
    color: Color,
    size: Dp
) {
    Canvas(modifier = Modifier.size(size)) {
        val outerRadius = size.toPx() / 2
        val innerRadius = outerRadius / 2.5f
        val centerX = size.toPx() / 2
        val centerY = size.toPx() / 2
        
        // Create a star path
        val starPath = Path().apply {
            moveTo(
                centerX,
                centerY - outerRadius
            )
            
            for (i in 1..9) {
                val angle = (i * 36) * (Math.PI / 180)
                val radius = if (i % 2 == 0) innerRadius else outerRadius
                lineTo(
                    centerX + radius * sin(angle).toFloat(),
                    centerY - radius * cos(angle).toFloat()
                )
            }
            
            close()
        }
        
        // Draw full star outline
        drawPath(
            path = starPath,
            color = color.copy(alpha = 0.3f),
            style = Stroke(width = 2f)
        )
        
        // Draw filled portion based on partialRatio
        if (partialRatio > 0f) {
            drawPath(
                path = starPath,
                color = color,
                alpha = partialRatio
            )
        }
    }
}