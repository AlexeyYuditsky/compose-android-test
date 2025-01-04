package com.alexeyyuditsky.learning.images.bitmap

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.SubcomposeAsyncImage
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.images.Container

enum class RequestState { NOT_LOADED, LOADED }

@Composable
fun ButtonClickAsyncImage() {
    var state by rememberSaveable { mutableStateOf(RequestState.NOT_LOADED) }

    Container(name = stringResource(R.string.button_click_async_image)) {
        when (state) {
            RequestState.NOT_LOADED -> LoadButton(listener = { state = RequestState.LOADED })

            RequestState.LOADED -> {
                SubcomposeAsyncImage(
                    model = "https://avatars.mds.yandex.net/get-vertis-journal/3911415/photo_2021-06-30_21-00-01.jpg_1625139537155/orig",
                    contentDescription = null,
                    loading = { CircularProgressIndicator() },
                    error = { Text(text = stringResource(R.string.load_failed), color = Color.Red) }
                )
            }
        }
    }
}

@Composable
fun LoadButton(listener: () -> Unit) {
    Button(onClick = listener) {
        Text(text = stringResource(R.string.load_image))
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonClickAsyncImagePreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        ButtonClickAsyncImage()
    }
}