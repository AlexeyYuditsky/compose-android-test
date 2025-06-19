package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Rectangle
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example10() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (startBound, endBound) = createRefs()

        Rectangle(
            width = 10.dp,
            height = 300.dp,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(startBound) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start, margin = 40.dp)
                }
        )

        Rectangle(
            width = 10.dp,
            height = 300.dp,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(endBound) {
                    centerVerticallyTo(parent)
                    end.linkTo(parent.end, margin = 40.dp)
                }
        )

        Square(
            size = 30.dp,
            color = Color.Red,
            modifier = Modifier
                .constrainAs(createRef()) {
                    linkTo(
                        start = startBound.end,
                        end = endBound.start,
                        top = startBound.top,
                        bottom = endBound.bottom,
                        horizontalBias = 0.25f,
                        verticalBias = 0.75f
                    )
                }
        )
    }
}