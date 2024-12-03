package com.alexeyyuditsky.learning

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun ButtonsExample(modifier: Modifier = Modifier) {
    Text(text = "Buttons example")
    Spacer(modifier.height(10.dp))
    Button(onClick = {

    }) {
        Text(text = "Click Me")
    }
    Text(text = "Count of clicks: ")
}