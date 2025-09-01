package org.moeen.basics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.moeen.basics.Navigation.AppNavigationNEW
import org.moeen.basics.theme.AppTheme

@Preview
@Composable
internal fun App() = AppTheme {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()) // respects safe area
    ) {
        AppNavigationNEW()
    }
}