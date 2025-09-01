package org.moeen.basics.Components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun PulltoRefreshScreen(navController: NavController) {
    // Add BackButton at the top
    BackButton(navController)
    
    val scope = rememberCoroutineScope()
    var isRefreshing by remember { mutableStateOf(false) }
    var items by remember { mutableStateOf(List(20) { "item ${'$'}it" }) }

    fun refreshItems() {
        scope.launch {
            isRefreshing = true
            delay(1200)
            items = List(20) { "item #${'$'}{(0..100).random()}" }
            isRefreshing = false
        }
    }

    PulltoRefreshCustomIndicatorSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = { refreshItems() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PulltoRefreshCustomIndicatorSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        modifier = modifier.fillMaxSize(),
        indicator = { MyCustomIndicator(state = state, isRefreshing = isRefreshing) }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LazyColumn(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                items(items) { item ->
                    ListItem({ Text(text = item) })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomIndicator(
    state: PullToRefreshState,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.pullToRefreshIndicator(
            state = state,
            isRefreshing = isRefreshing,
            containerColor = PullToRefreshDefaults.containerColor,
            threshold = PullToRefreshDefaults.PositionalThreshold
        ),
        contentAlignment = Alignment.Center
    ) {
        if (isRefreshing) {
            androidx.compose.material3.CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}