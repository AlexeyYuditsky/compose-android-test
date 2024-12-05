package com.alexeyyuditsky.learning

import android.os.Parcelable
import android.text.Layout.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
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
            return checkableItems.asSequence()
                .filter { it.isChecked.value }
                .map { it.title }
                .joinToString()
                .takeIf { it.isNotEmpty() } ?: "[nothing]"
        }

    companion object {
        val Saver: Saver<CheckBoxesState, *> = Saver(
            save = { state: CheckBoxesState ->
                ParcelableCheckBoxesState(
                    checkedItems = state.checkableItems.map {
                        ParcelableCheckableItem(
                            it.title,
                            it.isChecked.value
                        )
                    }
                )
            },
            restore = { state: ParcelableCheckBoxesState ->
                CheckBoxesState(
                    checkableItems = state.checkedItems.map {
                        CheckableItem(
                            it.title,
                            mutableStateOf(it.isChecked)
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
    val checkableItems = rememberSaveable(
        saver = Saver(
            save = { list -> list.map { it.isChecked.value } },
            restore = { saved ->
                saved.mapIndexed { index, isChecked ->
                    CheckableItem(
                        title = "Item ${index + 1}",
                        isChecked = mutableStateOf(isChecked)
                    )
                }
            }
        )
    ) {
        List(6) { index ->
            val id = index + 1
            CheckableItem(
                title = "Item $id",
                isChecked = mutableStateOf(false)
            )
        }
    }

    Column(modifier = modifier) {
        checkableItems.forEach { checkedItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        checkedItem.isChecked.value = !checkedItem.isChecked.value
                    },
                //verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedItem.isChecked.value,
                    onCheckedChange = { isChecked ->
                        checkedItem.isChecked.value = isChecked
                    },
                )
                Text(text = checkedItem.title)
            }
        }

        Text(
            text = "Selected Items: ${
                checkableItems.filter { it.isChecked.value }.joinToString { it.title }
            }"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxesExamplePreview() {
    CheckBoxesExample()
}