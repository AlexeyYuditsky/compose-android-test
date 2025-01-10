package com.alexeyyuditsky.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.alexeyyuditsky.learning.compositionLocalButton.AppTheme
import com.alexeyyuditsky.learning.compositionLocalButton.CompositionLocalButton
import com.alexeyyuditsky.learning.compositionLocalButton.LocalAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    CompositionLocalProvider(LocalAppTheme provides AppTheme.Dark) {
                        CompositionLocalButton()
                    }
                }
            }
        }
    }

}