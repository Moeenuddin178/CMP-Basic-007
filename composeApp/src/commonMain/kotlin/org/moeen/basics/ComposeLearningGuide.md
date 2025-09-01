# Jetpack Compose Learning Guide

## 1️⃣ Basic UI Components

### Learn the official UI widgets:

#### Text
```kotlin
@Composable
fun TextExample() {
    Text("Hello World")
    Text(
        text = "Styled Text",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}
```

#### Button
```kotlin
@Composable
fun ButtonExample() {
    Button(onClick = { /* Handle click */ }) {
        Text("Click me")
    }
    
    OutlinedButton(onClick = { /* Handle click */ }) {
        Text("Outlined Button")
    }
    
    TextButton(onClick = { /* Handle click */ }) {
        Text("Text Button")
    }
}
```

#### Image
```kotlin
@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.my_image),
        contentDescription = "Image description",
        modifier = Modifier.size(100.dp)
    )
}
```

#### Icon
```kotlin
@Composable
fun IconExample() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorite",
        tint = Color.Red
    )
}
```

#### TextField
```kotlin
@Composable
fun TextFieldExample() {
    var text by remember { mutableStateOf("") }
    
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") }
    )
}
```

#### Checkbox, Switch, RadioButton
```kotlin
@Composable
fun FormComponentsExample() {
    var checked by remember { mutableStateOf(false) }
    var switchState by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(0) }
    
    // Checkbox
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
    
    // Switch
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it }
    )
    
    // RadioButton
    Column {
        RadioButton(
            selected = selectedOption == 1,
            onClick = { selectedOption = 1 }
        )
        RadioButton(
            selected = selectedOption == 2,
            onClick = { selectedOption = 2 }
        )
    }
}
```

#### Slider
```kotlin
@Composable
fun SliderExample() {
    var sliderPosition by remember { mutableStateOf(0f) }
    
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f
    )
}
```

#### ProgressIndicator
```kotlin
@Composable
fun ProgressIndicatorExample() {
    // Indeterminate
    CircularProgressIndicator()
    
    // Determinate
    var progress by remember { mutableStateOf(0.5f) }
    CircularProgressIndicator(progress = progress)
}
```

### 📘 Practice: Build a Login Form UI
```kotlin
@Composable
fun LoginForm() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text("Remember me")
        }
        
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}
```

## 2️⃣ Layout System

### Understand how to arrange components:

#### Column, Row, Box
```kotlin
@Composable
fun LayoutExamples() {
    // Column - vertical arrangement
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("First item")
        Text("Second item")
        Text("Third item")
    }
    
    // Row - horizontal arrangement
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Left")
        Text("Center")
        Text("Right")
    }
    
    // Box - stacking elements
    Box(
        contentAlignment = Alignment.Center
    ) {
        // Background
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.LightGray)
        )
        // Foreground
        Text("Centered text")
    }
}
```

#### Modifiers: padding, size, fillMaxSize, background, clip, etc.
```kotlin
@Composable
fun ModifierExamples() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Fill entire parent
            .padding(16.dp) // Add padding
            .background(Color.Blue) // Set background color
            .clip(RoundedCornerShape(8.dp)) // Clip corners
            .size(100.dp) // Set fixed size
    ) {
        Text(
            "Content",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
```

#### Alignment & Arrangement
```kotlin
@Composable
fun AlignmentExamples() {
    // Column with different alignments
    Column(
        horizontalAlignment = Alignment.Start, // Align children to start
        verticalArrangement = Arrangement.Top // Arrange children at top
    ) {
        Text("Aligned to start")
    }
    
    // Row with different arrangements
    Row(
        verticalAlignment = Alignment.CenterVertically, // Align children vertically centered
        horizontalArrangement = Arrangement.SpaceAround // Distribute children with space around
    ) {
        Text("Item 1")
        Text("Item 2")
    }
}
```

#### Scrollable layouts: LazyColumn, LazyRow
```kotlin
@Composable
fun ScrollableExamples() {
    // Vertical scrolling list
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) { index ->
            Text(
                text = "Item $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
    
    // Horizontal scrolling list
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(100) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("Item $index")
                }
            }
        }
    }
}
```

#### Grids: LazyVerticalGrid (experimental)
```kotlin
@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Item $index")
                }
            }
        }
    }
}
```

### 📘 Practice: Build a Product List Page
```kotlin
@Composable
fun ProductListPage() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(20) { index ->
            ProductItem(
                name = "Product $index",
                price = "$${index * 10}",
                rating = (index % 5) + 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun ProductItem(
    name: String,
    price: String,
    rating: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Product image placeholder
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )
                
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                
                // Rating
                Row {
                    repeat(5) { starIndex ->
                        Icon(
                            imageVector = if (starIndex < rating) 
                                Icons.Default.Star 
                            else 
                                Icons.Default.StarBorder,
                            contentDescription = null,
                            tint = if (starIndex < rating) Color.Yellow else Color.Gray
                        )
                    }
                }
            }
        }
    }
}
```

## 3️⃣ Styling & Theming

### Colors, typography, shapes
```kotlin
@Composable
fun StylingExamples() {
    // Colors
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
    
    // Typography
    Text(
        text = "Headline",
        style = MaterialTheme.typography.headlineMedium
    )
    
    Text(
        text = "Body text",
        style = MaterialTheme.typography.bodyMedium
    )
    
    // Shapes
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp)
            )
    )
}
```

### Material 3 (MaterialTheme)
```kotlin
@Composable
fun Material3Example() {
    // Using Material 3 theme
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes
    ) {
        // Your content here
        Text(
            text = "Material 3 themed text",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
        )
    }
}
```

### Dark mode support
```kotlin
@Composable
fun ThemeExample() {
    // Theme with dark mode support
    MyAppTheme(
        darkTheme = isSystemInDarkTheme()
    ) {
        // Your app content
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            // Content
        }
    }
}

// In your theme file
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```

### Custom styling with Modifier
```kotlin
@Composable
fun CustomStylingExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Blue, Color.Green)
                ),
                shape = CircleShape
            )
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
            .shadow(
                elevation = 8.dp,
                shape = CircleShape
            )
    ) {
        Text(
            text = "Styled Box",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
```

### 📘 Practice: Make a Profile Card UI with rounded corners, shadows, and theme colors
```kotlin
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile picture
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile picture",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Name
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Email
            Text(
                text = "john.doe@example.com",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Bio
            Text(
                text = "Mobile developer passionate about creating beautiful UIs with Jetpack Compose",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /* Handle message */ }) {
                    Text("Message")
                }
                
                OutlinedButton(onClick = { /* Handle follow */ }) {
                    Text("Follow")
                }
            }
        }
    }
}
```

## 4️⃣ State & Interaction

### State handling: remember, derivedStateOf
```kotlin
@Composable
fun StateExamples() {
    // Simple state
    var count by remember { mutableStateOf(0) }
    
    // Derived state
    val isEven by remember { derivedStateOf { count % 2 == 0 } }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Count: $count")
        Text("Is even: $isEven")
        
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}
```

### State hoisting
```kotlin
@Composable
fun StateHoistingExample() {
    var textFieldValue by remember { mutableStateOf("") }
    
    CustomTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = "Enter text"
    )
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) }
    )
}
```

### Gesture handling (clickable, pointerInput)
```kotlin
@Composable
fun GestureExamples() {
    // Clickable
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .clickable { 
                // Handle click
            }
    ) {
        Text("Clickable", color = Color.White)
    }
    
    // Advanced gestures
    var offset by remember { mutableStateOf(Offset.Zero) }
    
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offset += dragAmount
                }
            }
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .offset { IntOffset(offset.x.toInt(), offset.y.toInt()) }
                .background(Color.Red)
        )
    }
}
```

### Animation basics (animate*AsState, AnimatedVisibility)
```kotlin
@Composable
fun AnimationExamples() {
    var visible by remember { mutableStateOf(true) }
    var size by remember { mutableStateOf(100.dp) }
    
    val animatedSize by animateDpAsState(
        targetValue = size,
        animationSpec = tween(durationMillis = 300),
        label = "size"
    )
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Animated visibility
        AnimatedVisibility(visible = visible) {
            Text("Hello, Animated World!")
        }
        
        Button(onClick = { visible = !visible }) {
            Text("Toggle Visibility")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Animated size
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
        )
        
        Button(onClick = { 
            size = if (size == 100.dp) 200.dp else 100.dp
        }) {
            Text("Animate Size")
        }
    }
}
```

### 📘 Practice: Create a Counter App with animations
```kotlin
@Composable
fun AnimatedCounterApp() {
    var count by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    
    val animatedCount by animateIntAsState(
        targetValue = count,
        animationSpec = if (isAnimating) 
            tween(durationMillis = 500, easing = FastOutSlowInEasing) 
        else 
            tween(durationMillis = 0),
        label = "count"
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Animated counter display
        Text(
            text = "$animatedCount",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Control buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    isAnimating = true
                    count--
                }
            ) {
                Icon(Icons.Default.Remove, contentDescription = "Decrement")
            }
            
            Button(
                onClick = {
                    isAnimating = true
                    count = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Reset")
            }
            
            Button(
                onClick = {
                    isAnimating = true
                    count++
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Increment")
            }
        }
    }
}
```

## 5️⃣ Advanced UI Components

### Tabs, Bottom Navigation
```kotlin
@Composable
fun TabsExample() {
    var tabIndex by remember { mutableStateOf(0) }
    
    val tabs = listOf("Home", "Search", "Profile")
    
    Column {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(title) }
                )
            }
        }
        
        // Content based on selected tab
        when (tabIndex) {
            0 -> HomeScreen()
            1 -> SearchScreen()
            2 -> ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationExample() {
    var selectedItem by remember { mutableStateOf(0) }
    
    val items = listOf("Home", "Search", "Favorites", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.Favorite,
        Icons.Default.Person
    )
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = null) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Content based on selected item
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Selected: ${items[selectedItem]}")
        }
    }
}
```

### Dialogs, Snackbars, Toast alternatives
```kotlin
@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }
    }
    
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirmation") },
            text = { Text("Are you sure you want to proceed?") },
            confirmButton = {
                TextButton(onClick = { 
                    // Handle confirm
                    showDialog = false
                }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun SnackbarExample() {
    val scope = rememberCoroutineScope()
    var snackbarHostState by remember { mutableStateOf(SnackbarHostState()) }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Hello, Snackbar!")
                    }
                }
            ) {
                Text("Show Snackbar")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Main Content")
        }
    }
}
```

### TopAppBar, Scaffold
```kotlin
@Composable
fun ScaffoldExample() {
    var drawerState by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                navigationIcon = {
                    IconButton(onClick = { drawerState = !drawerState }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Bottom App Bar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                text = "Content Area",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
```

### Drawers
```kotlin
@Composable
fun DrawerExample() {
    var drawerState by remember { mutableStateOf(false) }
    
    ModalDrawerSheet {
        Text("Drawer Content")
        // Drawer items
    }
}
```

### Custom Composables
```kotlin
@Composable
fun CustomProgressIndicator() {
    val infiniteTransition = rememberInfiniteTransition(label = "progress")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        ), label = "rotation"
    )
    
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .graphicsLayer { rotationZ = rotation }
        )
    }
}
```

### Canvas & drawing APIs
```kotlin
@Composable
fun DrawingExample() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        
        // Draw a circle
        drawCircle(
            color = Color.Blue,
            radius = 50f,
            center = Offset(canvasWidth / 2, canvasHeight / 2)
        )
        
        // Draw a line
        drawLine(
            color = Color.Red,
            start = Offset(0f, 0f),
            end = Offset(canvasWidth, canvasHeight),
            strokeWidth = 5f
        )
    }
}
```

### 📘 Practice: Build a News App Layout with top bar, bottom navigation, and list
```kotlin
@Composable
fun NewsAppLayout() {
    var selectedItem by remember { mutableStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    
    val items = listOf("Home", "Trending", "Bookmarks", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.TrendingUp,
        Icons.Default.Bookmark,
        Icons.Default.Person
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News App") },
                actions = {
                    IconButton(onClick = { /* Handle search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle notifications */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = null) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle new article */ }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        // News list content
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(20) { index ->
                NewsItem(
                    title = "Breaking News $index",
                    summary = "This is a summary of the breaking news item number $index. It contains important information that users need to know.",
                    time = "${index + 1}h ago",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun NewsItem(
    title: String,
    summary: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // News image placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Title
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Summary
            Text(
                text = summary,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Time and actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = time,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Row {
                    IconButton(onClick = { /* Handle share */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                    IconButton(onClick = { /* Handle bookmark */ }) {
                        Icon(Icons.Default.BookmarkBorder, contentDescription = "Bookmark")
                    }
                }
            }
        }
    }
}
```

## 6️⃣ Multiplatform-Specific UI

### Platform differences (Android, iOS, Desktop, Web)
```kotlin
@Composable
fun PlatformSpecificExample() {
    // Using expect/actual declarations
    val platformName = getPlatformName()
    
    Text("Running on: $platformName")
}

// In common code
expect fun getPlatformName(): String

// In Android source set
actual fun getPlatformName(): String = "Android"

// In iOS source set
actual fun getPlatformName(): String = "iOS"

// In Desktop source set
actual fun getPlatformName(): String = "Desktop"
```

### Input methods (keyboard handling on Desktop/iOS)
```kotlin
@Composable
fun KeyboardHandlingExample() {
    var text by remember { mutableStateOf("") }
    
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle done action
            }
        )
    )
}
```

### Window sizing & resizing (Desktop)
```kotlin
@Composable
fun DesktopWindowExample() {
    // This would be in desktop-specific code
    /*
    Window(
        title = "My App",
        state = rememberWindowState(
            width = 800.dp,
            height = 600.dp
        )
    ) {
        App()
    }
    */
}
```

### Adaptive layouts for different screens
```kotlin
@Composable
fun AdaptiveLayoutExample() {
    // Use LayoutDirection and screen size to adapt UI
    val configuration = LocalConfiguration.current
    val isLargeScreen = configuration.screenWidthDp > 600
    
    if (isLargeScreen) {
        // Tablet layout
        Row {
            // Sidebar
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Text("Sidebar")
            }
            
            // Main content
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text("Main Content")
            }
        }
    } else {
        // Phone layout
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    "Header",
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text("Main Content")
            }
        }
    }
}
```

### 📘 Practice: Build a Responsive Dashboard that runs on Android, Desktop, and iOS
```kotlin
@Composable
fun ResponsiveDashboard() {
    val configuration = LocalConfiguration.current
    val isLargeScreen = configuration.screenWidthDp > 800
    
    if (isLargeScreen) {
        // Desktop/Tablet layout
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Sidebar navigation
            SidebarNavigation(
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
            )
            
            // Main content area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                DashboardContent()
            }
        }
    } else {
        // Mobile layout
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Dashboard") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle menu */ }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigationBar()
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                DashboardContent()
            }
        }
    }
}

@Composable
fun SidebarNavigation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Text(
            "Navigation",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        // Navigation items
        val navItems = listOf("Dashboard", "Analytics", "Reports", "Settings")
        navItems.forEach { item ->
            TextButton(
                onClick = { /* Handle navigation */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(item)
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    
    val items = listOf("Home", "Analytics", "Reports", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Analytics,
        Icons.Default.Description,
        Icons.Default.Person
    )
    
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Composable
fun DashboardContent() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(12) { index ->
            DashboardCard(
                title = "Card $index",
                content = "This is the content of dashboard card number $index.",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { /* Handle action */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("View Details")
            }
        }
    }
}
```

## 7️⃣ Navigation

### Compose Navigation (for Android)
```kotlin
@Composable
fun NavigationExample() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToDetail = { itemId ->
                    navController.navigate("detail/$itemId")
                }
            )
        }
        
        composable("detail/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            DetailScreen(
                itemId = itemId ?: "",
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
```

### Multiplatform solutions (voyager, compose-destinations, or your own)
```kotlin
// Example with a simple custom navigation solution
@Composable
fun CustomNavigation() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    
    when (currentScreen) {
        is Screen.Home -> {
            HomeScreen(
                onNavigateToDetail = { itemId ->
                    currentScreen = Screen.Detail(itemId)
                }
            )
        }
        is Screen.Detail -> {
            DetailScreen(
                itemId = currentScreen.itemId,
                onNavigateBack = {
                    currentScreen = Screen.Home
                }
            )
        }
    }
}

sealed class Screen {
    object Home : Screen()
    data class Detail(val itemId: String) : Screen()
}
```

### 📘 Practice: Build a 3-Screen App with navigation
```kotlin
@Composable
fun ThreeScreenApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onNavigateToLogin = {
                    navController.navigate("login")
                },
                onNavigateToSignup = {
                    navController.navigate("signup")
                }
            )
        }
        
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home")
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("signup") {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate("home")
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("home") {
            HomeScreen(
                onLogout = {
                    navController.popBackStack("welcome", false)
                }
            )
        }
    }
}

@Composable
fun WelcomeScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToSignup: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Text(
            text = "Please login or signup to continue",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 48.dp)
        )
        
        Button(
            onClick = onNavigateToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Login")
        }
        
        OutlinedButton(
            onClick = onNavigateToSignup,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
        
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        
        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Login")
        }
        
        TextButton(
            onClick = { /* Handle forgot password */ }
        ) {
            Text("Forgot Password?")
        }
    }
}

@Composable
fun SignupScreen(
    onSignupSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
        
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        
        Button(
            onClick = onSignupSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Sign Up")
        }
    }
}

@Composable
fun HomeScreen(
    onLogout: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(Icons.Default.Logout, contentDescription = "Logout")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome to the Home Screen!",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
```

## 8️⃣ Animations & Transitions

### animateContentSize
```kotlin
@Composable
fun AnimateContentSizeExample() {
    var expanded by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .background(
                if (expanded) Color.Green else Color.Gray,
                RoundedCornerShape(8.dp)
            )
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Text(
            text = if (expanded) {
                "This is a long text that will be shown when the box is expanded. " +
                        "It demonstrates how animateContentSize can be used to smoothly " +
                        "animate the size of a composable when its content changes."
            } else {
                "Click to expand"
            }
        )
    }
}
```

### Crossfade
```kotlin
@Composable
fun CrossfadeExample() {
    var currentPage by remember { mutableStateOf("A") }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { 
            currentPage = if (currentPage == "A") "B" else "A"
        }) {
            Text("Toggle")
        }
        
        Crossfade(
            targetState = currentPage,
            animationSpec = tween(durationMillis = 1000)
        ) { screen ->
            when (screen) {
                "A" -> {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Red)
                    ) {
                        Text(
                            "Screen A",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                "B" -> {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Blue)
                    ) {
                        Text(
                            "Screen B",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}
```

### AnimatedContent
```kotlin
@Composable
fun AnimatedContentExample() {
    var count by remember { mutableStateOf(0) }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { count++ }) {
            Text("Increment")
        }
        
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState > initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(
                text = "$targetCount",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}
```

### Motion with updateTransition
```kotlin
@Composable
fun UpdateTransitionExample() {
    var isSelected by remember { mutableStateOf(false) }
    
    val transition = updateTransition(isSelected, label = "selection")
    
    val rectColor by transition.animateColor(
        label = "color"
    ) { selected ->
        if (selected) Color.Green else Color.Gray
    }
    
    val cornerRadius by transition.animateDp(
        label = "corner"
    ) { selected ->
        if (selected) 32.dp else 0.dp
    }
    
    val elevation by transition.animateDp(
        label = "elevation"
    ) { selected ->
        if (selected) 16.dp else 4.dp
    }
    
    Box(
        modifier = Modifier
            .size(200.dp)
            .shadow(elevation)
            .clip(RoundedCornerShape(cornerRadius))
            .background(rectColor)
            .clickable { isSelected = !isSelected }
    ) {
        Text(
            text = if (isSelected) "Selected" else "Not Selected",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
```

### 📘 Practice: Build an Onboarding Screen with transitions
```kotlin
@Composable
fun OnboardingScreen() {
    var currentPage by remember { mutableStateOf(0) }
    val pages = listOf(
        OnboardingPage(
            "Welcome!",
            "Get started with our amazing app",
            Icons.Default.Home
        ),
        OnboardingPage(
            "Features",
            "Discover all the great features we offer",
            Icons.Default.Star
        ),
        OnboardingPage(
            "Get Started",
            "You're all set to begin your journey",
            Icons.Default.Check
        )
    )
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Progress indicator
        LinearProgressIndicator(
            progress = (currentPage + 1) / pages.size.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        
        // Content area with transitions
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Crossfade(
                targetState = currentPage,
                animationSpec = tween(durationMillis = 500)
            ) { page ->
                OnboardingPageContent(pages[page])
            }
        }
        
        // Navigation buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (currentPage > 0) {
                Button(
                    onClick = { currentPage-- },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Previous")
                }
            } else {
                Spacer(modifier = Modifier.width(1.dp))
            }
            
            if (currentPage < pages.size - 1) {
                Button(
                    onClick = { currentPage++ }
                ) {
                    Text("Next")
                }
            } else {
                Button(
                    onClick = { /* Handle completion */ }
                ) {
                    Text("Get Started")
                }
            }
        }
    }
}

data class OnboardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector
)

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = page.icon,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 32.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
```

## 9️⃣ Performance & Best Practices

### Recomposition rules
```kotlin
@Composable
fun PerformanceExample() {
    // Good: Only the Text will recompose when count changes
    var count by remember { mutableStateOf(0) }
    
    Column {
        Text("Count: $count")
        
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
    
    // Bad: The entire MyExpensiveComposable will recompose
    /*
    var count by remember { mutableStateOf(0) }
    
    MyExpensiveComposable(count) // This whole function recomposes
    
    @Composable
    fun MyExpensiveComposable(count: Int) {
        // Expensive operations here
        Text("Count: $count")
    }
    */
    
    // Better: Extract the expensive parts
    /*
    var count by remember { mutableStateOf(0) }
    
    MyOptimizedComposable(count)
    
    @Composable
    fun MyOptimizedComposable(count: Int) {
        // Expensive operations here - but only run when needed
        val expensiveValue by remember(count) {
            mutableStateOf(calculateExpensiveValue(count))
        }
        
        Text("Count: $count, Expensive: $expensiveValue")
    }
    */
}
```

### remember vs rememberSaveable
```kotlin
@Composable
fun RememberVsRememberSaveable() {
    // This will be lost when the composable is disposed
    var count by remember { mutableStateOf(0) }
    
    // This will survive configuration changes (e.g., rotation)
    var savedCount by rememberSaveable { mutableStateOf(0) }
    
    Column {
        Text("Regular remember: $count")
        Text("Remember saveable: $savedCount")
        
        Button(onClick = { count++; savedCount++ }) {
            Text("Increment both")
        }
    }
}
```

### Keys in Lazy lists
```kotlin
@Composable
fun LazyListKeysExample() {
    val items = remember { mutableStateListOf("Item 1", "Item 2", "Item 3") }
    
    LazyColumn {
        // Good: Using keys to maintain item identity
        items(
            items = items,
            key = { item -> item } // Unique key for each item
        ) { item ->
            Text(item)
        }
    }
    
    // Bad: No keys - items might lose state when list changes
    /*
    LazyColumn {
        items(items) { item ->
            Text(item)
        }
    }
    */
}
```

### Optimizing images and layouts
```kotlin
@Composable
fun OptimizedLayoutExample() {
    // Good: Using Modifier.layoutId for custom layouts
    Layout(
        content = {
            Text("Header", Modifier.layoutId("header"))
            Text("Content", Modifier.layoutId("content"))
            Text("Footer", Modifier.layoutId("footer"))
        }
    ) { measurables, constraints ->
        // Custom layout logic
    }
    
    // Good: Using derivedStateOf for expensive calculations
    val list = remember { listOf(1, 2, 3, 4, 5) }
    val expensiveCalculation by remember(list) {
        derivedStateOf {
            list.map { it * it }.sum()
        }
    }
    
    Text("Expensive result: $expensiveCalculation")
}
```

## 🔮 Optional (Pro Level)

### Build Custom Layouts
```kotlin
@Composable
fun CustomFlowLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        // Measure and layout children in a flow pattern
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        
        layout(constraints.maxWidth, constraints.maxHeight) {
            var xPosition = 0
            var yPosition = 0
            var lineHeight = 0
            
            placeables.forEach { placeable ->
                if (xPosition + placeable.width > constraints.maxWidth) {
                    // Move to next line
                    xPosition = 0
                    yPosition += lineHeight
                    lineHeight = 0
                }
                
                placeable.placeRelative(xPosition, yPosition)
                xPosition += placeable.width
                lineHeight = maxOf(lineHeight, placeable.height)
            }
        }
    }
}
```

### Use Canvas + Graphics
```kotlin
@Composable
fun CustomDrawing() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        
        // Draw gradient background
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color.Blue, Color.Green),
                startY = 0f,
                endY = canvasHeight
            )
        )
        
        // Draw custom shape
        val path = Path().apply {
            moveTo(canvasWidth / 2, 50f)
            lineTo(canvasWidth / 2 - 50f, 150f)
            lineTo(canvasWidth / 2 + 50f, 150f)
            close()
        }
        
        drawPath(
            path = path,
            color = Color.Yellow
        )
    }
}
```

### Interop with platform-specific views (Android XML, UIKit in iOS)
```kotlin
// Android interop example
@Composable
fun AndroidViewExample() {
    /*
    AndroidView(
        factory = { context ->
            // Create and return Android view
            TextView(context).apply {
                text = "Hello from Android View"
            }
        },
        update = { view ->
            // Update the view
            view.text = "Updated text"
        }
    )
    */
}

// iOS interop would be in iOS source set using UIKit
```

### Styling for Web Compose
```kotlin
@Composable
fun WebStylingExample() {
    // Web-specific styling would be in web source set
    /*
    Box(
        modifier = Modifier
            .fillMaxSize()
            .style(
                Style(
                    backgroundColor = "#f0f0f0".toWebColor(),
                    padding = 16.px
                )
            )
    ) {
        Text("Web Styled Content")
    }
    */
}
```