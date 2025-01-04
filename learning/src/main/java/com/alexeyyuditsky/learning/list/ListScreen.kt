package com.alexeyyuditsky.learning.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListScreen() {
    val list = remember {
        List(30) { index -> "Simple text item ${index + 1}" }
    }

    LazyColumn {
        stickyHeader("Header 1")
        items(list) { item -> SimpleText(item) }
        stickyHeader("Header 2")
        items(list) { item -> SimpleText(item) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.stickyHeader(name: String) {
    stickyHeader { SimpleHeader(name) }
}

@Composable
private fun SimpleHeader(text: String) {
    Text(
        text = text,
        fontStyle = FontStyle.Italic,
        fontSize = 50.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .padding(horizontal = 16.dp)
    )
}

@Composable
private fun SimpleText(item: String) {
    Text(
        text = item,
        fontSize = 30.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ListScreenPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        ListScreen()
    }
}