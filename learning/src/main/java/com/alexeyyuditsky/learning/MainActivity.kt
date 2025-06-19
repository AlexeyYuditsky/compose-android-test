package com.alexeyyuditsky.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.alexeyyuditsky.learning.constraint.examples.Example1
import com.alexeyyuditsky.learning.constraint.examples.Example2
import com.alexeyyuditsky.learning.constraint.examples.Example3
import com.alexeyyuditsky.learning.constraint.examples.Example4
import com.alexeyyuditsky.learning.constraint.examples.Example5
import com.alexeyyuditsky.learning.constraint.examples.Example6
import com.alexeyyuditsky.learning.constraint.examples.Example7
import com.alexeyyuditsky.learning.constraint.examples.Example8
import com.alexeyyuditsky.learning.constraint.examples.Example9
import com.alexeyyuditsky.learning.constraint.examples.Example10
import com.alexeyyuditsky.learning.constraint.examples.Example11
import com.alexeyyuditsky.learning.constraint.examples.Example12
import com.alexeyyuditsky.learning.constraint.examples.Example13

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    Example13()
                }
            }
        }
    }

}