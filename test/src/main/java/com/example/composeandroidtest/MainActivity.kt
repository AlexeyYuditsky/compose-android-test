package com.example.composeandroidtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeandroidtest.ui.theme.ComposeandroidtestTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeandroidtestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        SideEffectExample(5)
                    }
                }
            }
        }
    }

}

@Composable
fun UserProfile(userId: String) {
    var userData by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(userId) {
        isLoading = true
        userData = fetchUserData(userId) // Долгая операция
        isLoading = false
    }

    if (isLoading) {
        Text("Loading...")
    } else {
        Text(userData)
    }
}

suspend fun fetchUserData(userId: String): String {
    delay(2000) // Симуляция долгой работы
    return "User data for $userId"
}

@Composable
fun SideEffectExample(counter: Int) {
    // Этот эффект вызывается при каждой рекомпозиции
    SideEffect {
        println("Counter updated: $counter")
    }

    Text("Counter: $counter")
}