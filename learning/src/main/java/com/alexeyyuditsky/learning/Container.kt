package com.alexeyyuditsky.learning

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
fun Container(
    name: String,
    content: @Composable ColumnScope.() -> Unit
) {

}