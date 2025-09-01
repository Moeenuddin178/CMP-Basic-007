package org.moeen.basics.Examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

// Data class for Product
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Float,
    val imageUrl: String = "", // In a real app, this would be an actual image URL
    val category: String
)

// Sample product data
val sampleProducts = listOf(
    Product(1, "Wireless Headphones", "High-quality wireless headphones with noise cancellation", 129.99, 4.5f, "", "Electronics"),
    Product(2, "Smart Watch", "Feature-rich smartwatch with health monitoring", 199.99, 4.2f, "", "Electronics"),
    Product(3, "Coffee Maker", "Automatic coffee maker with programmable settings", 89.99, 4.0f, "", "Home"),
    Product(4, "Running Shoes", "Comfortable running shoes with extra cushioning", 79.99, 4.7f, "", "Sports"),
    Product(5, "Bluetooth Speaker", "Portable speaker with 360-degree sound", 59.99, 4.3f, "", "Electronics"),
    Product(6, "Yoga Mat", "Non-slip yoga mat with carrying strap", 29.99, 4.1f, "", "Sports"),
    Product(7, "Desk Lamp", "LED desk lamp with adjustable brightness", 39.99, 4.4f, "", "Home"),
    Product(8, "Water Bottle", "Insulated water bottle keeps drinks cold for 24 hours", 24.99, 4.6f, "", "Sports")
)

@Composable
fun ProductListScreen(navController: NavController) {
    var products by remember { mutableStateOf(sampleProducts) }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    
    // Get unique categories
    val categories = listOf("All") + sampleProducts.map { it.category }.distinct()
    
    Scaffold(
        topBar = {
            Column {
                // Back button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    BackButton(navController = navController)
                }
                
                // Screen title
                Text(
                    text = "Product List",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                
                // Category filter
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(categories) { category ->
                        Card(
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .clickable {
                                    selectedCategory = if (category == "All") null else category
                                    products = if (selectedCategory == null) {
                                        sampleProducts
                                    } else {
                                        sampleProducts.filter { it.category == selectedCategory }
                                    }
                                },
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (selectedCategory == category || (selectedCategory == null && category == "All")) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.surfaceVariant
                                }
                            )
                        ) {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (selectedCategory == category || (selectedCategory == null && category == "All")) {
                                    MaterialTheme.colorScheme.onPrimary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product, onAddToCart = { /* Handle add to cart */ })
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Product name and rating
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color.Yellow,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = product.rating.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            
            // Product description
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            
            // Price and Add to Cart button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${String.format("%.2f", product.price)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                
                IconButton(
                    onClick = onAddToCart,
                    modifier = Modifier
                        .size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddShoppingCart,
                        contentDescription = "Add to Cart",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}