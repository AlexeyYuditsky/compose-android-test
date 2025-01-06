package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexeyyuditsky.learning.R

@Composable
fun DifficultItem(
    modifier: Modifier = Modifier,
    user: User,
    listener: () -> Unit
) {
    Card(
        modifier = modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(size = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Image(
                painter = painterResource(R.drawable.img1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .align(Alignment.CenterVertically),
            )
            Column(
                modifier = modifier
                    .weight(0.8f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = user.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.padding(vertical = 4.dp))
                Text(
                    text = user.text,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.DarkGray
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = modifier
                    .weight(0.2f)
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { listener() }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DifficultItemPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        DifficultItem(
            user = User(
                "Alex Ivanov 5",
                "asdasd as dsad  sad sadasdasdsa asdasd asd asd asdas"
            ),
            listener = {}
        )
    }
}