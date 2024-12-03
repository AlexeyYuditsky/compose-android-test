package com.alexeyyuditsky.learning

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.alexeyyuditsky.core.logCompositionLifecycle
import kotlinx.parcelize.Parcelize

@Parcelize
data class Counter(
    val value: Int
) : Parcelable

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier,
    counter: Int,
    incrementedValue: (Int) -> Unit
) {
    logCompositionLifecycle("StatefulCounter")
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = counter.toString(),
            fontSize = 35.sp
        )
        Spacer(modifier = modifier.height(12.dp))
        Button(onClick = { incrementedValue(counter + 1) }) {
            Text(text = "increment")
        }
        Box(modifier = modifier.height(100.dp)) {
            if (counter % 2 == 0) {
                logCompositionLifecycle("texttrue")
                Text(
                    text = "true",
                    fontSize = 18.sp
                )
            }
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
        Box(modifier = modifier.height(100.dp)) {
            if (true) {
                Text(
                    text = "true",
                    fontSize = 18.sp
                )
            }
        }
    }
}