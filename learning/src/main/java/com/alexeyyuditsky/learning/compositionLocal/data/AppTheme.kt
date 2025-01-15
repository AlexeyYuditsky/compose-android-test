package com.alexeyyuditsky.learning.compositionLocal.data

import androidx.compose.ui.graphics.Color

data class AppTheme(
    val buttonColor: Color,
    val backgroundColor: Color
) {
    companion object {
        val Light = AppTheme(
            buttonColor = Color.Blue,
            backgroundColor = Color.White
        )

        val Dark = AppTheme(
            buttonColor = Color.Black,
            backgroundColor = Color.DarkGray
        )
    }
}