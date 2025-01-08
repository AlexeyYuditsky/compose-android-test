package com.alexeyyuditsky.learning.singletonDiffrenetList.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alexeyyuditsky.learning.singletonDiffrenetList.model.UsersService

@Preview(showSystemUi = true)
@Composable
fun SingletonUserCardScreen() {
    val usersService = UsersService.Base
    val userList by usersService.getUsers().collectAsStateWithLifecycle()
    val context = LocalContext.current

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        items(
            items = userList,
            key = { user -> user.id }
        ) { user ->
            UserCard(
                user = user,
                onUserDelete = usersService::removeUser,
                onUserClicked = { Toast.makeText(context, user.name, Toast.LENGTH_SHORT).show() }
            )
        }
    }
}