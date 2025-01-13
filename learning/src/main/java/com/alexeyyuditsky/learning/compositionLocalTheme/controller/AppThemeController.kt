package com.alexeyyuditsky.learning.compositionLocalTheme.controller

import com.alexeyyuditsky.learning.compositionLocalTheme.data.AppTheme
import com.alexeyyuditsky.learning.compositionLocalTheme.data.ThemeDataSource

interface AppThemeController {

    fun toggle()

    class Base(
        private val themeDataSource: ThemeDataSource
    ) : AppThemeController {

        override fun toggle() {
            val newTheme = if (themeDataSource.themeStateFlow.value == AppTheme.Light) {
                AppTheme.Dark
            } else {
                AppTheme.Light
            }
            themeDataSource.setTheme(newTheme)
        }

    }

    object Empty : AppThemeController {
        override fun toggle() = Unit
    }

}