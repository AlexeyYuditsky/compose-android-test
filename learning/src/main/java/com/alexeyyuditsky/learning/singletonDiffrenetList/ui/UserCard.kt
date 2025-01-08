package com.alexeyyuditsky.learning.singletonDiffrenetList.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.alexeyyuditsky.learning.singletonDiffrenetList.model.User

@Preview
@Composable
fun UserCard(
    @PreviewParameter(UserPreviewProvider::class) user: User,
    modifier: Modifier = Modifier,
    onUserClicked: (() -> Unit)? = null,
    onUserDelete: ((user: User) -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(size = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier.clickable(
            interactionSource = null,
            indication = ripple(),
            onClick = { onUserClicked?.invoke() }
        )
    ) {
        Row(modifier = modifier.padding(all = 8.dp)) {
            UserImage(image = user.photoUrl)
            Spacer(modifier = modifier.width(16.dp))
            UserInfo(name = user.name, status = user.status)
            DeleteUserButton(onUserDelete = { onUserDelete?.invoke(user) })
        }
    }
}

@Composable
private fun UserImage(
    image: String,
    modifier: Modifier = Modifier
) {
    val placeHolder = rememberVectorPainter(image = Icons.Rounded.AccountCircle)

    if (LocalInspectionMode.current) {
        Icon(
            painter = placeHolder,
            contentDescription = null,
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape)
        )
    } else {
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
}

@Composable
private fun RowScope.UserInfo(
    name: String,
    status: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.weight(1f)) {
        Text(
            text = name,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = modifier.height(6.dp))
        Text(
            text = status,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun RowScope.DeleteUserButton(
    onUserDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onUserDelete,
        modifier = modifier.align(Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = null
        )
    }
}

private class UserPreviewProvider : PreviewParameterProvider<User> {
    override val values = sequenceOf(
        User(
            id = 1,
            photoUrl = "",
            name = "Gandalf",
            status = "Lorem ipsum"
        ),
        User(
            id = 1,
            photoUrl = "",
            name = "Gandalf the White, the leader of the feel and we can mre beautiful strange commit header",
            status = "Gandalf the White, the leader of the feel and we can mre beautiful strange commit header"
        )
    )
}