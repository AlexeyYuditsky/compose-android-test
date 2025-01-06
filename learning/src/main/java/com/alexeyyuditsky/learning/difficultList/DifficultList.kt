package com.alexeyyuditsky.learning.difficultList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class User(
    val name: String,
    val text: String
)

val userList = List(100) { index ->
    User(
        "Alex Ivanov $index",
        "asdasd as dsad  sad sadasdasdsa asdasd asd asd asdas"
    )
}

@Composable
fun DifficultList() {
    var userList by remember { mutableStateOf(userList) }

    LazyColumn {
        items(userList) { user ->
            DifficultItem(
                user = user,
                listener = { userList = userList.filter { it != user } }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DifficultListPreview() {
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        DifficultList()
    }
}