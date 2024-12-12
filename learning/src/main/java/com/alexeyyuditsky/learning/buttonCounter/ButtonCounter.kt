package com.alexeyyuditsky.learning.buttonCounter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCounter(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = state.toString(),
        )
        Button(
            modifier = modifier,
            onClick = { state += 1 }
        ) {
            Text("Increment")
        }
        Spacer(modifier = modifier.padding(10.dp))
        Box(
            modifier = modifier
                .background(Color.Blue)
                .padding(20.dp)
                .offset {
                    IntOffset(0, 20)
                }
        ) {
            Text(text = "text", color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonCounterPreview() {
    ButtonCounter()
}