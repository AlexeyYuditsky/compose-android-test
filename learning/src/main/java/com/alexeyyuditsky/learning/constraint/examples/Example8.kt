package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Square

@Preview(showSystemUi = true)
@Composable
fun Example8() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val largeSquare = createRef()
        val (innerLeftSquare, innerRightSquare, innerTopSquare, innerBottomSquare) = createRefs()
        val (outerLeftSquare, outerRightSquare, outerTopSquare, outerBottomSquare) = createRefs()

        Square(
            modifier = Modifier
                .size(200.dp)
                .constrainAs(largeSquare) {
                    centerTo(parent)
                }
        )

        Square(
            color = Color.Blue,
            modifier = Modifier
                .size(50.dp)
                .constrainAs(innerLeftSquare) {
                    centerVerticallyTo(largeSquare)
                    start.linkTo(largeSquare.start)
                }
        )

        Square(
            color = Color.Blue,
            modifier = Modifier
                .size(50.dp)
                .constrainAs(innerRightSquare) {
                    centerVerticallyTo(largeSquare)
                    end.linkTo(largeSquare.end)
                }
        )

        Square(
            color = Color.Blue,
            modifier = Modifier
                .size(50.dp)
                .constrainAs(innerTopSquare) {
                    centerHorizontallyTo(largeSquare)
                    top.linkTo(largeSquare.top)
                }
        )

        Square(
            color = Color.Blue,
            modifier = Modifier
                .size(50.dp)
                .constrainAs(innerBottomSquare) {
                    centerHorizontallyTo(largeSquare)
                    bottom.linkTo(largeSquare.bottom)
                }
        )

        Square(
            color = Color.Green,
            modifier = Modifier
                .size(75.dp)
                .constrainAs(outerLeftSquare) {
                    centerVerticallyTo(parent)
                    end.linkTo(largeSquare.start)
                }
        )

        Square(
            color = Color.Green,
            modifier = Modifier
                .size(75.dp)
                .constrainAs(outerRightSquare) {
                    centerVerticallyTo(parent)
                    start.linkTo(largeSquare.end)
                }
        )

        Square(
            color = Color.Green,
            modifier = Modifier
                .size(75.dp)
                .constrainAs(outerTopSquare) {
                    centerHorizontallyTo(parent)
                    bottom.linkTo(largeSquare.top)
                }
        )

        Square(
            color = Color.Green,
            modifier = Modifier
                .size(75.dp)
                .constrainAs(outerBottomSquare) {
                    centerHorizontallyTo(parent)
                    top.linkTo(largeSquare.bottom)
                }
        )
    }
}