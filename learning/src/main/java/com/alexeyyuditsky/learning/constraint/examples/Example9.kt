package com.alexeyyuditsky.learning.constraint.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alexeyyuditsky.learning.constraint.Hint
import com.alexeyyuditsky.learning.constraint.Rectangle

@Preview(showSystemUi = true)
@Composable
fun Example9() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (
            startBound, endBound, rectFillToConstraint, rectMatchParent, rectPercentage,
            rectWrapContent, rectPrefWrapContent, rectPreferredValue, prefAspectRatio
        ) = createRefs()

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

        Hint(rectFillToConstraint, "fill to constraint")
        Rectangle(
            modifier = Modifier
                .constrainAs(rectFillToConstraint) {
                    start.linkTo(startBound.end)
                    end.linkTo(endBound.start)
                    top.linkTo(startBound.top, margin = 10.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(20.dp)
                }
        )

        Hint(rectMatchParent, "match parent")
        Rectangle(
            modifier = Modifier
                .constrainAs(rectMatchParent) {
                    top.linkTo(rectFillToConstraint.bottom, margin = 30.dp)
                    width = Dimension.matchParent
                    height = Dimension.value(20.dp)
                }
        )

        Hint(rectPercentage, "percentage")
        Rectangle(
            modifier = Modifier
                .constrainAs(rectPercentage) {
                    top.linkTo(rectMatchParent.bottom, margin = 30.dp)
                    centerHorizontallyTo(parent)
                    width = Dimension.percent(0.7f)
                    height = Dimension.value(20.dp)
                }
        )

        Hint(rectWrapContent, "wrap content")
        Text(
            text = "123",
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .padding(horizontal = 6.dp, vertical = 2.dp)
                .constrainAs(rectWrapContent) {
                    centerHorizontallyTo(parent)
                    top.linkTo(rectPercentage.bottom, margin = 30.dp)
                    width = Dimension.wrapContent
                    height = Dimension.value(20.dp)
                }
        )

        Hint(rectPrefWrapContent, "preferred wrap content")
        Text(
            text = "Lorem ipsum color sds dsd 123123 sadsad d666",
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .background(Color.Red)
                .padding(horizontal = 6.dp, vertical = 2.dp)
                .constrainAs(rectPrefWrapContent) {
                    top.linkTo(rectWrapContent.bottom, margin = 30.dp)
                    start.linkTo(startBound.end)
                    end.linkTo(endBound.start)
                    width = Dimension.preferredWrapContent
                    height = Dimension.value(20.dp)
                }
        )

        Hint(rectPreferredValue, "preferred value")
        Rectangle(
            modifier = Modifier
                .constrainAs(rectPreferredValue) {
                    top.linkTo(rectPrefWrapContent.bottom, margin = 30.dp)
                    start.linkTo(startBound.end)
                    end.linkTo(endBound.start)
                    width = Dimension.preferredValue(200.dp)
                    height = Dimension.value(20.dp)
                }
        )

        Hint(prefAspectRatio, "aspect ratio")
        Rectangle(
            modifier = Modifier
                .constrainAs(prefAspectRatio) {
                    top.linkTo(rectPreferredValue.bottom, margin = 30.dp)
                    start.linkTo(startBound.end)
                    end.linkTo(endBound.start)
                    width = Dimension.percent(0.25f)
                    height = Dimension.ratio("2:3")
                }
        )
    }
}