package com.alexeyyuditsky.learning.images.vector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexeyyuditsky.learning.R
import com.alexeyyuditsky.learning.images.Container

@Composable
fun IconWithModifier() {
    Container(name = stringResource(R.string.vector_icon_with_modifier)) {
        Icon(
            painter = painterResource(R.drawable.ic_umbrella),
            contentDescription = stringResource(R.string.vector_icon_with_modifier),
            modifier = Modifier
                .size(48.dp)
                .background(color = Color.LightGray, shape = CircleShape)
                .padding(8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun IconWithModifierPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        IconWithModifier()
    }
}