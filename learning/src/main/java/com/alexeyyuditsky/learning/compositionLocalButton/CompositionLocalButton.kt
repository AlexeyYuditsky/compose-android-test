package com.alexeyyuditsky.learning.compositionLocalButton

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

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
            buttonColor = Color.Gray,
            backgroundColor = Color.Black
        )
    }
}

val LocalAppTheme = compositionLocalOf {
    AppTheme.Light
}

@Preview(showSystemUi = true)
@Composable
fun CompositionLocalButton() {
    val context = LocalContext.current
    val theme = LocalAppTheme.current
    CompositionLocalProvider(
        LocalAppTheme provides theme.copy(buttonColor = Color.Magenta)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(theme.backgroundColor)
        ) {
            CustomButton(
                onClick = { Toast.makeText(context, "World", Toast.LENGTH_SHORT).show() },
                text = "Hello"
            )
        }
    }
}

@Composable
private fun CustomButton(
    onClick: () -> Unit,
    text: String
) {
    val theme = LocalAppTheme.current
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = theme.buttonColor),
    ) {
        Text(text = text)
    }
}