package com.alexeyyuditsky.core

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember

@Composable
fun logCompositionLifecycle(name: String): Any = remember {
    LifecycleRememberObserver(name)
}

private class LifecycleRememberObserver(
    private val name: String
) : RememberObserver {
    override fun onForgotten() {
        Log.d("MyLog", "$name.onLeave")
    }

    override fun onRemembered() {
        Log.d("MyLog", "$name.onEnter")
    }

    override fun onAbandoned() = Unit
}