package com.alexeyyuditsky.learning.mainComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Container(name = "Buttons example") {
            ButtonsExample()
        }
        Container(name = "TextField example") {
            TextFieldExample()
        }
        Container(name = "CheckBox example") {
            CheckBoxesExample()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppScreenPreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Container(name = "Buttons example") {
            ButtonsExample()
        }
        Container(name = "TextField example") {
            TextFieldExample()
        }
        Container(name = "CheckBox example") {
            CheckBoxesExample()
        }
    }
}