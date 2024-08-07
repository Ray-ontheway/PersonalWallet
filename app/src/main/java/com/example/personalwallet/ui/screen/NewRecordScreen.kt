package com.example.personalwallet.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalwallet.ui.component.AppTopBar
import com.example.personalwallet.ui.icon.WalletIcons
import com.example.personalwallet.viewmodel.MainViewModel
import timber.log.Timber

@Composable
fun NewRecordRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    NewRecordScreen(onBackClick = onBackClick, modifier = modifier)
}

@Composable
fun NewRecordScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTopBar(
            onBackClick = onBackClick,
            onOptionClick = { Timber.i("点击选项按钮") },
            title = "New Record"
        )
        NewRecordCard()
    }
}

/**
 * 账单类型
 * 金额
 * 日期
 * Icon 图标 Icon
 * 备注
 */
@Composable
fun NewRecordCard(
    modifier: Modifier = Modifier
) {

    val selectedType = remember { mutableStateOf(null) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val comment = remember { mutableStateOf("") }
    val options = listOf("Income", "Expenses")
    val expanded = remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf("") }

    val type = remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {

            OutlinedTextField(
                value = type.value,
                onValueChange = { type.value = it },
                label = { Text(text = "Select Type") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "CNY",
                        modifier = Modifier
                    )
                },
                modifier = Modifier
                    .background(Color.Red)
                    .padding(16.dp)
                    .focusRequester(focusRequester)
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            focusManager.clearFocus()
                            expanded.value = true
                        }
                    },
            )

            if (expanded.value) {
                Dialog(
                    onDismissRequest = { expanded.value = false },
                ) {
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false }) {
                        options.forEach { option ->
                            DropdownMenuItem(
                                onClick = {
                                    type.value = option
                                    selectedOption.value = option
                                    expanded.value = false
                                },
                                text = {
                                    Text(text = option)
                                }
                            )

                        }
                    }
                }
            }
            OutlinedTextField(
                value = "",
                placeholder = { Text(text = "") },
                onValueChange = {},
                label = { Text(text = "AMOUNT") },
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.TwoTone.Image,
                        contentDescription = "CNY"
                    )
                },
                trailingIcon = {
                    Text(text = "Clear", modifier = Modifier, fontWeight = FontWeight.Bold)
                },
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "DATE") },
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.DateRange,
                        contentDescription = "CNY"
                    )
                }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "AMOUT") },
                modifier = Modifier
                    .background(Color.Yellow)
                    .padding(16.dp),
                trailingIcon = {
                    Icon(
                        imageVector = WalletIcons.BACK,
                        contentDescription = "CNY"
                    )
                }
            )
            OutlinedTextField(
                value = comment.value,
                onValueChange = { comment.value = it },
                modifier = Modifier
                    .background(Color.Cyan)
                    .padding(16.dp)
                    .height(80.dp),
            )
        }
    }
}

@Preview
@Composable
fun NewRecordCardPreview() {
    NewRecordCard()
}


