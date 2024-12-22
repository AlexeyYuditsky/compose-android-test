package com.alexeyyuditsky.learning.images.bitmap

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.images.Container

@Composable
fun ClippedWithCustomShapeImage() {
    Container(name = stringResource(R.string.clipped_image)) {
        Image(
            painter = painterResource(R.drawable.img1),
            contentDescription = stringResource(R.string.random_architecture_showcase),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(GenericShape { size, _ ->
                    moveTo(0f, size.height)
                    lineTo(size.width / 2, 0f)
                    lineTo(size.width, size.height)
                })
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ClippedWithCustomShapeImagePreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        ClippedWithCustomShapeImage()
    }
}