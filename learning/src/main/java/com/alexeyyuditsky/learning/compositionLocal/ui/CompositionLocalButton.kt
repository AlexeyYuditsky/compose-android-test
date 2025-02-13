package com.alexeyyuditsky.learning.compositionLocal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.compositionLocal.LocalAppTheme
import com.alexeyyuditsky.learning.compositionLocal.LocalAppThemeController

@Preview(showSystemUi = true)
@Composable
fun CompositionLocalTheme() {
    val theme = LocalAppTheme.current
    val themeController = LocalAppThemeController.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(theme.backgroundColor)
    ) {
        CustomButton(
            onClick = themeController::toggle,
            text = stringResource(R.string.changeAppTheme)
        )
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
        colors = ButtonDefaults.buttonColors(containerColor = theme.buttonColor)
    ) {
        Text(text = text)
    }
}