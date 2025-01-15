package com.alexeyyuditsky.learning.compositionLocal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alexeyyuditsky.learning.compositionLocal.controller.AppThemeController
import com.alexeyyuditsky.learning.compositionLocal.data.AppTheme
import com.alexeyyuditsky.learning.compositionLocal.data.ThemeDataSource

val LocalAppTheme = compositionLocalOf { AppTheme.Light }
val LocalAppThemeController =
    staticCompositionLocalOf<AppThemeController> { AppThemeController.Empty }

@Composable
fun AppThemeContainer(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val themeDataSource = remember { ThemeDataSource.Base(context) }
    val appThemeController = remember { AppThemeController.Base(themeDataSource) }
    val theme by themeDataSource.themeStateFlow.collectAsStateWithLifecycle()

    CompositionLocalProvider(
        LocalAppTheme provides theme,
        LocalAppThemeController provides appThemeController,
    ) {
        content()
    }
}