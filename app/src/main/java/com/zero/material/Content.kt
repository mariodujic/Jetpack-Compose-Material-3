package com.zero.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.zero.material.ui.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {

    var showDialog by rememberSaveable { mutableStateOf(false) }

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem(title = "Songs", icon = Icons.Filled.List),
        NavigationItem(title = "Artists", icon = Icons.Filled.PlayArrow),
        NavigationItem(title = "Playlists", icon = Icons.Filled.Build)
    )

    AppTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = "Top App Bar") },
                    modifier = Modifier.shadow(5.dp)
                )
            },
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                }
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                OutlinedButton(onClick = { showDialog = true }) {
                    Text(text = "Button")
                }
                FilledTonalButton(onClick = { showDialog = true }) {
                    Text(text = "Button")
                }
                ElevatedButton(onClick = { showDialog = true }) {
                    Text(text = "Button")
                }
                Button(onClick = { showDialog = true }) {
                    Text(text = "Button")
                }
                TextButton(onClick = { showDialog = true }) {
                    Text(text = "Button")
                }
                ExtendedFloatingActionButton(
                    icon = { Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = "") },
                    text = { Text(text = "Floating button") },
                    onClick = { showDialog = true }
                )
            }
        }
        CustomAlertDialog(showDialog = showDialog) {
            showDialog = false
        }
    }
}