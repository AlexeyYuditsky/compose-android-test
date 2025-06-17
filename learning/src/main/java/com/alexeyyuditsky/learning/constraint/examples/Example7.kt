package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example7() {
    ConstraintLayout {
        Square(
            modifier = Modifier
                .constrainAs(createRef()) {
                    start.linkTo(parent.start, margin = 20.dp)
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )

        Square(
            modifier = Modifier
                .constrainAs(createRef()) {
                    start.linkTo(parent.start, margin = 20.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                }
        )

        Square(
            modifier = Modifier
                .constrainAs(createRef()) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )

        Square(
            modifier = Modifier
                .constrainAs(createRef()) {
                    end.linkTo(parent.end, margin = 20.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                }
        )
    }
}