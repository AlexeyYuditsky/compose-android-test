package com.alexeyyuditsky.learning.buttonCounter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCounter(modifier: Modifier = Modifier) {
    var countState by rememberSaveable { mutableIntStateOf(0) }
    val offsetState by remember {
        derivedStateOf {
            val newValue = 20 * (countState / 3)
            newValue
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = countState.toString(),
            fontSize = 50.sp
        )
        Button(
            modifier = modifier,
            onClick = { ++countState }
        ) {
            Text(
                text = "Increment",
                fontSize = 18.sp
            )
        }
        Text(
            text = "text",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = modifier
                .size(60.dp)
                .offset {
                    println("My layout - $offsetState")
                    IntOffset(x = 0, y = offsetState)
                }
                .background(Color.Blue)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonCounterPreview() {
    ButtonCounter()
}