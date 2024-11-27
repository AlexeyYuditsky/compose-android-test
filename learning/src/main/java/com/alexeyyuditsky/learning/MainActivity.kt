package com.alexeyyuditsky.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { HelloWorld() }
    }

}

@Preview(
    showSystemUi = true,
)
@Composable
fun HelloWorld(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .background(Color.Cyan)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier
                    .background(Color.Yellow)
                    .weight(1f)
                    .align(BiasAlignment.Horizontal(0.2f)),
                text = "Hello!",
                fontSize = 35.sp,
                color = Color.Red
            )
            Text(
                modifier = modifier
                    .background(Color.Green)
                    .weight(2f)
                    .align(BiasAlignment.Horizontal(-0.8f)),
                text = "Gandalf",
                fontSize = 15.sp,
                color = Color.Blue
            )
            Text(
                modifier = modifier
                    .background(Color.Red)
                    .weight(1f)
                    .align(BiasAlignment.Horizontal(-0.8f)),
                text = "42",
                fontSize = 35.sp,
                color = Color.Green
            )
        }
    }
}