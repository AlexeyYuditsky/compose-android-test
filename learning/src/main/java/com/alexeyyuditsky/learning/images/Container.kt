package com.alexeyyuditsky.learning.images

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Container(
    modifier: Modifier = Modifier,
    name: String,
    content: @Composable BoxScope.() -> Unit
) {
    Card(
        border = BorderStroke(width = 1.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(size = 4.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 0.dp, max = 100.dp)
            .padding(vertical = 6.dp, horizontal = 12.dp)
    ) {
        Row(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Box(
                content = content,
                contentAlignment = Alignment.Center,
                modifier = modifier.weight(1.0f)
            )
            Spacer(modifier = modifier.width(6.dp))
            Text(
                text = name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(2.0f)
            )
        }
    }
}