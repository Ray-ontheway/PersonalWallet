package com.example.personalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.ui.icon.WalletIcons

@Composable
fun AppTopBar(
    onBackClick: () -> Unit,
    onOptionClick: () -> Unit,
    title: String = "",
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier.fillMaxWidth().height(60.dp).padding(10.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = WalletIcons.BACK,
            contentDescription = "Back",
            modifier = modifier.fillMaxHeight()
                .width(60.dp)
                .padding(12.dp)
                .clickable { onBackClick() }
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f),
        )
        Image(
            imageVector = WalletIcons.OPTION,
            contentDescription = "System Settings",
            modifier = modifier.fillMaxHeight()
                .width(60.dp)
                .padding(12.dp)
                .clickable { onOptionClick() }
        )
    }
}

@Preview
@Composable
fun AppTopBarPreview() {
    AppTopBar(onBackClick = {}, onOptionClick = {}, title = "Title")
}