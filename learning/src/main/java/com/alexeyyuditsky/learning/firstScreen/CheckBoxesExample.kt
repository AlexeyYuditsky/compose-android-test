package com.alexeyyuditsky.learning.firstScreen

import android.os.Parcelable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.parcelize.Parcelize

data class CheckableItem(
    val title: String,
    val isChecked: MutableState<Boolean>
)

data class CheckBoxesState(
    val checkableItems: List<CheckableItem>
) {
    val selectedItemNames: String
        get() {
            return checkableItems
                .filter { it.isChecked.value }
                .joinToString { it.title }
                .takeIf { it.isNotEmpty() } ?: "[nothing]"
        }

    companion object {
        val Saver: Saver<CheckBoxesState, *> = Saver(
            save = { state: CheckBoxesState ->
                ParcelableCheckBoxesState(
                    checkedItems = state.checkableItems.map {
                        ParcelableCheckableItem(
                            title = it.title,
                            isChecked = it.isChecked.value
                        )
                    }
                )
            },
            restore = { state: ParcelableCheckBoxesState ->
                CheckBoxesState(
                    checkableItems = state.checkedItems.map {
                        CheckableItem(
                            title = it.title,
                            isChecked = mutableStateOf(it.isChecked)
                        )
                    }
                )
            }
        )
    }
}

@Parcelize
data class ParcelableCheckableItem(
    val title: String,
    val isChecked: Boolean
) : Parcelable

@Parcelize
data class ParcelableCheckBoxesState(
    val checkedItems: List<ParcelableCheckableItem>
) : Parcelable

@Composable
fun CheckBoxesExample(modifier: Modifier = Modifier) {
    val state = rememberSaveable(saver = CheckBoxesState.Saver) {
        CheckBoxesState(
            checkableItems = List(6) { index ->
                CheckableItem(
                    title = "Item ${index + 1}",
                    isChecked = mutableStateOf(false)
                )
            }
        )
    }

    state.checkableItems.forEach { checkedItem ->
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedItem.isChecked.value,
                onCheckedChange = { checkedItem.isChecked.value = !checkedItem.isChecked.value }
            )
            Text(text = checkedItem.title)
        }
    }

    Text(text = "Selected Items: ${state.selectedItemNames}")
}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxesExamplePreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Container(name = "CheckBox example") {
            CheckBoxesExample()
        }
    }
}