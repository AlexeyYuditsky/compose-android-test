package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example6() {
    ConstraintLayout {
        Square(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .constrainAs(createRef()) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Square(
            modifier = Modifier
                .padding(start = 20.dp, bottom = 20.dp)
                .constrainAs(createRef()) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )

        Square(
            modifier = Modifier
                .padding(end = 20.dp, top = 20.dp)
                .constrainAs(createRef()) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )

        Square(
            modifier = Modifier
                .padding(end = 20.dp, bottom = 20.dp)
                .constrainAs(createRef()) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )

    }
}