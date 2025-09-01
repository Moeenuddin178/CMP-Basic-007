package org.moeen.basics.Components.Forms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun InputChipExample(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
    // Add BackButton at the top
    BackButton(navController)

        Text(
            text = "Input Chips Examples",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Basic Input Chip
        BasicInputChipExample()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Tag Selection Chips
        TagSelectionExample()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Contact Chips
        ContactChipsExample()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Filter Chips
        FilterChipsExample()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Skill Chips
        SkillChipsExample()
    }
}

@Composable
private fun BasicInputChipExample() {
    var isSelected by remember { mutableStateOf(false) }
    
    Column {
        Text(
            text = "Basic Input Chip",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        InputChip(
            onClick = { isSelected = !isSelected },
            label = { Text("Click me") },
            selected = isSelected,
            avatar = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Person",
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = if (isSelected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Selected",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else null
        )
    }
}

@Composable
private fun TagSelectionExample() {
    val tags = listOf("Kotlin", "Compose", "Android", "iOS", "Desktop", "Multiplatform")
    var selectedTags by remember { mutableStateOf(setOf<String>()) }
    
    Column {
        Text(
            text = "Tag Selection (${selectedTags.size} selected)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tags.chunked(3).forEach { rowTags ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowTags.forEach { tag ->
                        val isSelected = tag in selectedTags

            InputChip(
                onClick = {
                                selectedTags = if (isSelected) {
                                    selectedTags - tag
                                } else {
                                    selectedTags + tag
                                }
                            },
                            label = { Text(tag) },
                            selected = isSelected,
                            leadingIcon = if (isSelected) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = "Selected",
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            } else null
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactChipsExample() {
    data class Contact(val name: String, val icon: ImageVector)
    
    val contacts = listOf(
        Contact("John Doe", Icons.Filled.Person),
        Contact("Jane Smith", Icons.Filled.PersonOutline),
        Contact("Bob Wilson", Icons.Filled.Face),
        Contact("Alice Brown", Icons.Filled.AccountCircle)
    )
    
    var selectedContacts by remember { mutableStateOf(setOf<Contact>()) }
    
    Column {
        Text(
            text = "Contact Selection (${selectedContacts.size} selected)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start)
        ) {
            contacts.forEach { contact ->
                val isSelected = contact in selectedContacts
                
                InputChip(
                    onClick = {
                        selectedContacts = if (isSelected) {
                            selectedContacts - contact
                        } else {
                            selectedContacts + contact
                        }
                    },
                    label = { Text(contact.name) },
                    selected = isSelected,
                    avatar = {
                        Icon(
                            imageVector = contact.icon,
                            contentDescription = contact.name,
                            modifier = Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    },
                    trailingIcon = if (isSelected) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Remove",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    } else null
                )
            }
        }
    }
}

@Composable
private fun FilterChipsExample() {
    data class Filter(val name: String, val icon: ImageVector)
    
    val filters = listOf(
        Filter("Price: Low to High", Icons.Filled.AttachMoney),
        Filter("Rating: 4+", Icons.Filled.Star),
        Filter("Free Shipping", Icons.Filled.LocalShipping),
        Filter("In Stock", Icons.Filled.Inventory)
    )
    
    var activeFilters by remember { mutableStateOf(setOf<Filter>()) }
    
    Column {
        Text(
            text = "Filter Options (${activeFilters.size} active)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filters.chunked(2).forEach { rowFilters ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowFilters.forEach { filter ->
                        val isActive = filter in activeFilters
                        
                        InputChip(
                            onClick = {
                                activeFilters = if (isActive) {
                                    activeFilters - filter
                                } else {
                                    activeFilters + filter
                                }
                            },
                            label = { Text(filter.name) },
                            selected = isActive,
                            leadingIcon = {
                                Icon(
                                    imageVector = filter.icon,
                                    contentDescription = filter.name,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            trailingIcon = if (isActive) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Clear,
                                        contentDescription = "Clear filter",
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            } else null
                        )
                    }
                }
            }
        }
        
        if (activeFilters.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = { activeFilters = setOf() }
                ) {
                    Text("Clear All")
                }
            }
        }
    }
}

@Composable
private fun SkillChipsExample() {
    val skills = listOf(
        "UI/UX Design", "Frontend Development", "Backend Development",
        "Mobile Development", "DevOps", "Data Science",
        "Project Management", "Quality Assurance"
    )
    
    var userSkills by remember { mutableStateOf(setOf<String>()) }
    
    Column {
        Text(
            text = "Select Your Skills (${userSkills.size} selected)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        // Show selected skills first
        if (userSkills.isNotEmpty()) {
            Text(
                text = "Selected: ${userSkills.joinToString(", ")}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        // Skill chips
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.chunked(2).forEach { rowSkills ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowSkills.forEach { skill ->
                        val isSelected = skill in userSkills
                        
                        InputChip(
                            onClick = {
                                userSkills = if (isSelected) {
                                    userSkills - skill
                                } else {
                                    userSkills + skill
                                }
                            },
                            label = { Text(skill) },
                            selected = isSelected,
                            leadingIcon = if (isSelected) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.CheckCircle,
                                        contentDescription = "Selected",
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            } else {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "Add",
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}