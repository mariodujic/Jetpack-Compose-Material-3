package com.zero.material

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomAlertDialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            title = { Text(text = "Title") },
            text = { Text(text = "Message") },
            confirmButton = {
                FilledTonalButton(onClick = dismissDialog) {
                    Text(text = "Close")
                }
            },
            onDismissRequest = dismissDialog
        )
    }
}