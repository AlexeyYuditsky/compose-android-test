package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example2() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        Square(
            modifier = Modifier.constrainAs(createRef()) {
                centerTo(parent)
            }
        )
    }
}