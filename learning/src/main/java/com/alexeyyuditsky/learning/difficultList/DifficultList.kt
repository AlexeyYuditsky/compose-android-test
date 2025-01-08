package com.alexeyyuditsky.learning.difficultList

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.javafaker.Faker

class User(
    val id: Long,
    val name: String,
    val photoUrl: String,
    val text: String
)

fun createUserList(): List<User> {
    val faker = Faker.instance()
    val imageList = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK_mAcrV3vVhLq6HK4c1liqGV59qhOwXdEGw&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScNKRGajUtPdVgerx1W_bEw4D4F0RPc9X-dA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzQ8apUKBGvv6rqPPsEO_CNVvwbuB7dZb2WA&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWJaa44hakF5skS3g1dAqjMEuMAR6MgAetFw&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHOeRhjNU_IZv5Hry8YvZEpJvHRAckAZznAw&s"
    )

    return List(200) { index ->
        User(
            id = index.toLong(),
            name = faker.name().fullName(),
            photoUrl = imageList[index % imageList.size],
            text = faker.gameOfThrones().quote()
        )
    }
}

@Composable
fun DifficultList() {
    var userList by rememberSaveable { mutableStateOf(createUserList()) }
    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        items(
            items = userList,
            key = { user -> user.id }
        ) { user ->
            DifficultItem(
                user = user,
                onUserDelete = { userList -= user },
                onUserClicked = { Toast.makeText(context, user.name, Toast.LENGTH_SHORT).show() }
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