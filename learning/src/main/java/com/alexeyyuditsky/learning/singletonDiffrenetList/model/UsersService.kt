package com.alexeyyuditsky.learning.singletonDiffrenetList.model

import com.github.javafaker.Faker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

interface UsersService {

    fun getUsers(): StateFlow<List<User>>

    fun removeUser(user: User)

    object Base : UsersService {

        private val usersMutableStateFlow = MutableStateFlow(generateUsers())

        override fun getUsers(): StateFlow<List<User>> = usersMutableStateFlow

        override fun removeUser(user: User) {
            usersMutableStateFlow.update { oldUserList -> oldUserList - user }
        }

        private fun generateUsers(): List<User> {
            val faker = Faker.instance()
            val imageList = listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK_mAcrV3vVhLq6HK4c1liqGV59qhOwXdEGw&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScNKRGajUtPdVgerx1W_bEw4D4F0RPc9X-dA&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzQ8apUKBGvv6rqPPsEO_CNVvwbuB7dZb2WA&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWJaa44hakF5skS3g1dAqjMEuMAR6MgAetFw&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHOeRhjNU_IZv5Hry8YvZEpJvHRAckAZznAw&s"
            )

            return List(100) { index ->
                User(
                    id = index.toLong(),
                    photoUrl = imageList[index % imageList.size],
                    name = faker.name().fullName(),
                    status = faker.gameOfThrones().quote()
                )
            }
        }

    }

}