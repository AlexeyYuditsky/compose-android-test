package com.alexeyyuditsky.learning.firstScreen

import android.os.Parcelable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class ButtonState(
    private val buttonColor: Int = android.graphics.Color.YELLOW,
    private val pressCount: Int = 0
) : Parcelable {

    fun getNewTextColor(): Int {
        return if (android.graphics.Color.luminance(buttonColor) > 0.5) {
            android.graphics.Color.BLACK
        } else {
            android.graphics.Color.WHITE
        }
    }

    fun getNewPressCount(): Int = pressCount + 1

    fun getNewButtonColor(): Int = buttonColor

}

@Composable
fun ButtonsExample(modifier: Modifier = Modifier) {
    var buttonState by rememberSaveable { mutableStateOf(ButtonState()) }

    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(buttonState.getNewButtonColor())),
        shape = RoundedCornerShape(size = 12.dp),
        border = BorderStroke(width = 2.dp, color = Color.Black),
        onClick = {
            val newButtonColor = -Random.nextInt(0xFFFFFF)
            buttonState = buttonState.copy(
                buttonColor = newButtonColor,
                pressCount = buttonState.getNewPressCount()
            )
        },
    ) {
        Text(text = "Click Me", color = Color(buttonState.getNewTextColor()))
    }

    Text(text = "Count of clicks: ${buttonState.getNewPressCount()}")
}

@Preview(showSystemUi = true)
@Composable
fun ButtonsExamplePreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Container(name = "Buttons example") {
            ButtonsExample()
        }
    }
}