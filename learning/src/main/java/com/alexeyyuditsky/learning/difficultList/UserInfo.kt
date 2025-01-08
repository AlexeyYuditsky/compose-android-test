package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.UserInfo(
    name: String,
    text: String,
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
            text = text,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp
        )
    }
}