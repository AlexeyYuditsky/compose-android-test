package com.alexeyyuditsky.learning.images.bitmap

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import coil3.compose.AsyncImage
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.images.Container

enum class RequestState { NOT_LOADED, LOADED }

@Composable
fun ButtonClickAsyncImage() {
    var state by rememberSaveable { mutableStateOf(RequestState.NOT_LOADED) }

    Container(name = stringResource(R.string.button_click_async_image)) {
        when (state) {
            RequestState.NOT_LOADED -> LoadButton { state = RequestState.LOADED }

            RequestState.LOADED -> {
                AsyncImage(
                    model = "https://avatars.mds.yandex.net/get-vertis-journal/3911415/photo_2021-06-30_21-00-01.jpg_1625139537155/orig",
                    contentDescription = null
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