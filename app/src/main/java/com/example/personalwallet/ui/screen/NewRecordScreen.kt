package com.example.personalwallet.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Tab
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Box(modifier = modifier) {
        AppTopBar(onBackClick = onBackClick, onOptionClick = { Timber.i("点击选项按钮") }, title = "New Record")
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

    val comment = remember { mutableStateOf("") }

    Card(modifier = Modifier.background(Color.White)) {
        Column {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "TYPE") },
                modifier = Modifier.padding(16.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Tab,
                        contentDescription = "CNY"
                    )
                }
            )
            OutlinedTextField(
                value = "",
                placeholder = { Text(text = "") },
                onValueChange = {},
                label = { Text(text = "AMOUNT") },
                modifier = Modifier.padding(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.TwoTone.Image,
                        contentDescription = "CNY"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = WalletIcons.BACK,
                        contentDescription = "CNY"
                    )
                },
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "DATE") },
                modifier = Modifier.padding(16.dp),
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
                modifier = Modifier.padding(16.dp),
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
                modifier = Modifier.padding(16.dp).height(80.dp),)
        }
    }
}

@Preview
@Composable
fun NewRecordCardPreview() {
    NewRecordCard()
}
