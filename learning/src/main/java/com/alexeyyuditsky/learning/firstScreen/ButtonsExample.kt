package com.alexeyyuditsky.learning.firstScreen

import android.os.Parcelable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class ButtonState(
    val buttonColor: Int = android.graphics.Color.YELLOW,
    val pressCount: Int = 0
) : Parcelable {

    @IgnoredOnParcel
    val textColor: Int by lazy(LazyThreadSafetyMode.NONE) {
        if (android.graphics.Color.luminance(buttonColor) > 0.5) {
            android.graphics.Color.BLACK
        } else {
            android.graphics.Color.WHITE
        }
    }

}

@Composable
fun ButtonsExample(modifier: Modifier = Modifier) {
    var buttonState by rememberSaveable {
        mutableStateOf(ButtonState())
    }
    Button(
        modifier = modifier.fillMaxSize(),
        onClick = {
            val newButtonColor = -Random.nextInt(0xFFFFFF)
            buttonState = buttonState.copy(
                buttonColor = newButtonColor,
                pressCount = buttonState.pressCount + 1
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(buttonState.buttonColor)
        ),
        shape = RoundedCornerShape(size = 12.dp),
        border = BorderStroke(width = 2.dp, color = Color.Black),
    ) {
        Text(text = "Click Me", color = Color(buttonState.textColor))
    }
    Text(text = "Count of clicks: ${buttonState.pressCount}")
}