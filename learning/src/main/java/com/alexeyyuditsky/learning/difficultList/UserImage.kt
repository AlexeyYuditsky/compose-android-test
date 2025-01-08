package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.alexeyyuditsky.learning.R

@Composable
fun UserImage(
    image: String,
    modifier: Modifier = Modifier
) {
    val placeHolder = rememberVectorPainter(image = Icons.Rounded.AccountCircle)
    AsyncImage(
        model = image,
        placeholder = placeHolder,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun UserImagePreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        Image(
            painter = painterResource(R.drawable.img1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
    }
}