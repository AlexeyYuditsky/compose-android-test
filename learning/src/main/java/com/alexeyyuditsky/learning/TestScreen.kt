package com.alexeyyuditsky.learning

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.parcelize.Parcelize

@Parcelize
data class Counter(
    val value: Int
) : Parcelable

@Composable
fun StatefulCounter(modifier: Modifier = Modifier, counter: Int, incrementedValue: (Int) -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "5",
            fontSize = 35.sp
        )
        Spacer(modifier = modifier.height(12.dp))
        Button(onClick = { incrementedValue(counter + 1) }) {
            Text(text = "increment")
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun StatefulCounterPreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "5",
            fontSize = 35.sp
        )
        Spacer(modifier = modifier.height(12.dp))
        Button(onClick = { }) {
            Text(text = "increment")
        }
    }
}