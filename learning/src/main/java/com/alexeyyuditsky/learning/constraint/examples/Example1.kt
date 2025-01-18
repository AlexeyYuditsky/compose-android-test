package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example1() {
    ConstraintLayout {
        Square(
            color = Color.Red,
            size = 200.dp
        )
        Square(
            color = Color.Blue,
            size = 150.dp
        )
        Square(
            color = Color.Green,
            size = 100.dp
        )
    }
}