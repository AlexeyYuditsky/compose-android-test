package com.alexeyyuditsky.learning.compositionLocalTheme.data

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface ThemeDataSource {

    val themeStateFlow: StateFlow<AppTheme>

    fun setTheme(theme: AppTheme)

    class Base(context: Context) : ThemeDataSource {

        private val preferences = context.getSharedPreferences(
            THEME_PREFERENCES_NAME, Context.MODE_PRIVATE
        )

        override var themeStateFlow: MutableStateFlow<AppTheme> = MutableStateFlow(readTheme())

        override fun setTheme(theme: AppTheme) {
            preferences.edit {
                putInt(KEY_BUTTON_COLOR, theme.buttonColor.toArgb())
                putInt(KEY_BACKGROUND_COLOR, theme.backgroundColor.toArgb())
            }
            themeStateFlow.value = theme
        }

        private fun readTheme(): AppTheme {
            if (!hasSavedTheme()) return AppTheme.Light
            return AppTheme(
                buttonColor = Color(preferences.getInt(KEY_BUTTON_COLOR, 0)),
                backgroundColor = Color(preferences.getInt(KEY_BACKGROUND_COLOR, 0))
            )
        }

        private fun hasSavedTheme(): Boolean = preferences.contains(THEME_PREFERENCES_NAME)

        private companion object {
            const val THEME_PREFERENCES_NAME = "theme"
            const val KEY_BUTTON_COLOR = "buttonColor"
            const val KEY_BACKGROUND_COLOR = "backgroundColor"
        }

    }

}