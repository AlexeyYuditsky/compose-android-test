package com.alexeyyuditsky.learning.images

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexeyyuditsky.learning.images.bitmap.ClippedImage
import com.alexeyyuditsky.learning.images.bitmap.ScaleCropImage
import com.alexeyyuditsky.learning.images.bitmap.SimpleImage
import com.alexeyyuditsky.learning.images.bitmap.SquareImage
import com.alexeyyuditsky.learning.images.vector.IconWithModifier
import com.alexeyyuditsky.learning.images.vector.MaterialIcon
import com.alexeyyuditsky.learning.images.vector.TintedVectorIcon
import com.alexeyyuditsky.learning.images.vector.VectorIcon

@Composable
fun ImagesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MaterialIcon()
        IconWithModifier()
        VectorIcon()
        TintedVectorIcon()
        SimpleImage()
        ScaleCropImage()
        SquareImage()
        ClippedImage()
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImagesScreenPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        ImagesScreen()
    }
}