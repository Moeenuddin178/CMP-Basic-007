package org.moeen.basics

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.moeen.basics.Navigation.Routes
import org.moeen.basics.Components.Layouts.HomeTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column {
        HomeTopBar()
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            val items = listOf(
                "Image asset 🖼️" to Routes.AccessImage,
                "Text asset 📝" to Routes.TextAccess,
                "Outlined Border ✏️" to Routes.BorderOutlined,
                "Selectable Text 👆" to Routes.SelectableTextScreen,
                "Simple Password  🔒" to Routes.SimplePassword,
                "Password with hide 🔒" to Routes.PasswordViewScreen,
                "Rainbow Text 🌈" to Routes.RainbowTextScreen,
                "Scrollable Text 📜" to Routes.ScrollableTextScreen,
                "Annotated String 🔗" to Routes.AnnotatedStringwithListenerSample,
                "Shadow Text 🌫️" to Routes.ShadowText,
                "Image Show 🖼️" to Routes.Imageshow,
                "Box 📦" to Routes.Box,
                "Column 🧱" to Routes.Columnexample,
                "Row ➡️" to Routes.RowExample,
                "Lazy Column 📃" to Routes.LazyColumn,
                "Lazy Row 📶" to Routes.LazyRow,
                "Modifier 🛠️" to Routes.Modifier,
                "Bottom Sheet ⬆️" to Routes.BottomSheet,
                "Alert Dialog ⚠️" to Routes.Dialog,
                "Theme Handler 🎨" to Routes.AppTheme,
                "Animated Box 📦" to Routes.Animation,
                "Bottom Navigation ⬇️" to Routes.BottomNavigation,
                "Detailed Drawer 📁" to Routes.DetailedDrawer,
                "Badges 🚫" to Routes.Badges,
                "Check Box ✅" to Routes.CheckBox,
                "Date Picker 📅" to Routes.DatePicker,
                "Floating Action Button ➕" to Routes.FloatingActionButton,
                "Progress Indicator ⏳" to Routes.ProgressIndicator,
                "Scaffold 🏠" to Routes.Scaffold,
                "Search Bar 🔍" to Routes.SearchBar,
                "Segmented Button 🔘" to Routes.SegmentedButton,
                "Slider 🟢" to Routes.Slider,
                "Snack Bar 🔔" to Routes.SnackBar,
                "Switch 💡" to Routes.Switch,
                "Top App Bar ⬆️" to Routes.TopAppBar,
                "Drop Down Menu ⬇️" to Routes.DropDownMenu,
                "Pull To Refresh" to Routes.Pulltorefresh,
                "Bottom Navigation ⬇️" to Routes.BottomNavigation,
                "Detailed Drawer 📁" to Routes.DetailedDrawer,
                "Badges 🚫" to Routes.Badges,
                "Elevated Card 🚫" to Routes.ElevatedCard,
                "Input Chip" to Routes.InputChip,
                "Time Picker ⏰" to Routes.Timepicker,
                "Login Form 🔐" to Routes.LoginForm,
                "Product List 🛍️" to Routes.ProductList,
                "Profile Card 👤" to Routes.ProfileCard,
                "Counter App 🔢" to Routes.CounterApp,
                "Custom Composables 🎨" to Routes.CustomComposables,
                "Canvas Graphics 🎨" to Routes.CanvasGraphics,



            )



            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items) { (label, route) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), // make all cards equal
                        elevation = CardDefaults.cardElevation(6.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { navController.navigate(route) }
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                fontWeight = FontWeight.Light,
                                fontSize = 13.sp,
                                color = Color(0xFF222222),
                                lineHeight = 20.sp,
                                letterSpacing = 0.2.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .fillMaxWidth()
                            )

                        }
                    }
                }
            }

        }

    }

}