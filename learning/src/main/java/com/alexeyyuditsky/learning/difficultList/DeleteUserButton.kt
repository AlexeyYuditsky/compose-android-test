package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RowScope.DeleteUserButton(
    onUserDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onUserDelete,
        modifier = modifier.align(Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = null
        )
    }
}