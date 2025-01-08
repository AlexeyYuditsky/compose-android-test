package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexeyyuditsky.learning.R

@Composable
fun DifficultItem(
    user: User,
    onUserDelete: () -> Unit,
    onUserClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(size = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier.clickable(
            interactionSource = null,
            indication = ripple(),
            onClick = { onUserClicked() }
        )
    ) {
        Row(modifier = modifier.padding(all = 8.dp)) {
            UserImage(image = user.photoUrl)
            Spacer(modifier = modifier.width(16.dp))
            UserInfo(name = user.name, text = user.text)
            DeleteUserButton(onUserDelete = onUserDelete)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DifficultItemPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        Card(
            shape = RoundedCornerShape(size = 6.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier.clickable(
                interactionSource = null,
                indication = ripple(),
                onClick = { }
            )
        ) {
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Image(
                    painter = painterResource(R.drawable.img1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                UserInfo(name = "Alexey", text = "Random text")
                DeleteUserButton(onUserDelete = {})
            }
        }
    }
}