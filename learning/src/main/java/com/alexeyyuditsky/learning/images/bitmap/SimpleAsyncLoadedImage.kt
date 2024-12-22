package com.alexeyyuditsky.learning.images.bitmap

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.alexeyyuditsky.learning.images.Container

@Composable
fun SimpleAsyncLoadedImage() {
    Container(name = "Simple Async Load by Coil") {
        AsyncImage(
            model = "https://avatars.mds.yandex.net/get-vertis-journal/3911415/photo_2021-06-30_21-00-01.jpg_1625139537155/orig",
            contentDescription = null
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SimpleAsyncLoadedImagePreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        SimpleAsyncLoadedImage()
    }
}