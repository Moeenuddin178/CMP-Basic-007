package org.moeen.basics.Examples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CanvasGraphicsScreen(navController: NavController) {
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
            text = "Canvas Graphics Examples",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center
        )
        
        // Canvas graphics examples
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Basic Shapes
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
                        text = "Basic Shapes",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Canvas(modifier = Modifier.size(200.dp)) {
                        // Draw a rectangle
                        drawRect(
                            color = Color.Blue,
                            topLeft = Offset(20f, 20f),
                            size = Size(100f, 50f)
                        )
                        
                        // Draw a circle
                        drawCircle(
                            color = Color.Red,
                            radius = 30f,
                            center = Offset(150f, 50f)
                        )
                        
                        // Draw an oval
                        drawOval(
                            color = Color.Green,
                            topLeft = Offset(50f, 100f),
                            size = Size(100f, 60f)
                        )
                    }
                }
            }
            
            // Lines and Paths
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
                        text = "Lines and Paths",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Canvas(modifier = Modifier.size(200.dp)) {
                        // Draw a simple line
                        drawLine(
                            color = Color.Black,
                            start = Offset(20f, 20f),
                            end = Offset(180f, 20f),
                            strokeWidth = 5f,
                            cap = StrokeCap.Round
                        )
                        
                        // Draw a path (triangle)
                        val path = Path().apply {
                            moveTo(100f, 50f)
                            lineTo(50f, 150f)
                            lineTo(150f, 150f)
                            close()
                        }
                        drawPath(
                            path = path,
                            color = Color.Magenta
                        )
                        
                        // Draw points
                        val points = listOf(
                            Offset(30f, 180f),
                            Offset(70f, 180f),
                            Offset(110f, 180f),
                            Offset(150f, 180f)
                        )
                        drawPoints(
                            points = points,
                            pointMode = PointMode.Points,
                            color = Color.Cyan,
                            strokeWidth = 10f
                        )
                    }
                }
            }
            
            // Advanced Drawing
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
                        text = "Advanced Drawing",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    var rotation by remember { mutableStateOf(0f) }
                    
                    Canvas(modifier = Modifier.size(200.dp)) {
                        // Draw a rotating arc
                        drawArc(
                            color = Color.Yellow,
                            startAngle = rotation,
                            sweepAngle = 90f,
                            useCenter = true,
                            topLeft = Offset(50f, 50f),
                            size = Size(100f, 100f)
                        )
                        
                        // Draw a custom shape (star)
                        val starPath = Path().apply {
                            val centerX = 100f
                            val centerY = 50f
                            val outerRadius = 40f
                            val innerRadius = 20f
                            
                            moveTo(
                                centerX,
                                centerY - outerRadius
                            )
                            
                            for (i in 1..9) {
                                val angle = (i * 36 + rotation.toInt()) * (Math.PI / 180)
                                val radius = if (i % 2 == 0) innerRadius else outerRadius
                                lineTo(
                                    centerX + radius * sin(angle).toFloat(),
                                    centerY - radius * cos(angle).toFloat()
                                )
                            }
                            
                            close()
                        }
                        
                        drawPath(
                            path = starPath,
                            color = Color(0xFF9C27B0)
                        )
                    }
                }
            }
            
            // Gradient Example
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
                        text = "Gradient Effects",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Canvas(modifier = Modifier.size(200.dp)) {
                        // Draw a rectangle with linear gradient effect using multiple colors
                        drawRect(
                            color = Color(0xFFE91E63),
                            topLeft = Offset(20f, 20f),
                            size = Size(160f, 50f)
                        )
                        
                        // Draw overlapping rectangles to simulate gradient
                        for (i in 0..10) {
                            val alpha = i / 10f
                            drawRect(
                                color = Color(0xFF2196F3).copy(alpha = alpha),
                                topLeft = Offset(20f + i * 14f, 90f),
                                size = Size(14f, 50f)
                            )
                        }
                    }
                }
            }
        }
        
        // Add some spacing at the bottom
        Box(modifier = Modifier.height(24.dp))
    }
}