package com.alexeyyuditsky.learning

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldExample(modifier: Modifier = Modifier) {
    var textValue by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier.fillMaxSize(),
        value = textValue,
        onValueChange = { updatedText ->
            textValue = updatedText
        },
        singleLine = true
    )
    Spacer(modifier = modifier.height(6.dp))
    Text(text = textValue.ifBlank { "[empty]" })
}

@Preview(showSystemUi = true)
@Composable
fun TExtFieldExamplePreview() {
    TextFieldExample()
}