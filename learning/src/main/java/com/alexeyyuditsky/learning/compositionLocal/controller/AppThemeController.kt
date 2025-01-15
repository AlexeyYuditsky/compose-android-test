package com.alexeyyuditsky.learning.compositionLocal.controller

import com.alexeyyuditsky.learning.compositionLocal.data.AppTheme
import com.alexeyyuditsky.learning.compositionLocal.data.ThemeDataSource

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