package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alexeyyuditsky.learning.constraint.Rectangle

@Preview(showSystemUi = true)
@Composable
fun Example9() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (startBound, endBound, rectFillToConstraint) = createRefs()

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

        Column(
            modifier = Modifier.constrainAs(rectFillToConstraint) {
                top.linkTo(startBound.top)
                start.linkTo(startBound.end)
                end.linkTo(endBound.start)
            }
        ) {
            Text(text = "fill to constraint")
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .size(width = 10.dp, height = 10.dp)
            )
        }


    }
}