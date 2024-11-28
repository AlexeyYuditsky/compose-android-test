package com.alexeyyuditsky.learning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Preview(
    showSystemUi = true,
)
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var counterMutableState = rememberSaveable { mutableStateOf(Random.nextInt()) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = counterMutableState.value.toString(),
            fontSize = 35.sp
        )
        Spacer(modifier = modifier.height(12.dp))
        Button(onClick = {
            counterMutableState.value =
                counterMutableState.value + 1
        }) {
            Text(text = "increment")
        }
    }
}

