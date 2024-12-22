package com.alexeyyuditsky.learning.images.bitmap

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.images.Container

@Composable
fun SimpleImage() {
    Container(name = stringResource(R.string.simple_image)) {
        Image(
            painter = painterResource(R.drawable.img1),
            contentDescription = stringResource(R.string.random_architecture_showcase),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SimpleImagePreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        SimpleImage()
    }
}