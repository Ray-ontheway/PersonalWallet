package com.example.personalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.personalwallet.ui.icon.WalletIcons
import com.example.personalwallet.ui.theme.PersonalWalletTheme

@Composable
fun ListHeader(
    title: String,
    actionStr: String = "see all",
    icon: ImageVector? = null,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
     Row(
         modifier = modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.SpaceBetween
     ) {
         Text(text = title, fontSize = 20.sp, color = Color.Black)
         if (icon == null) {
             Text(text = actionStr, fontSize = 18.sp, color = Color.Black, modifier = Modifier.clickable { action() })
         } else {
             Image(imageVector = icon, contentDescription = "option",
                 modifier = Modifier.clickable { action() })
         }
     }
}

@Preview
@Composable
fun ListHeaderStrPreview() {
    PersonalWalletTheme {
        ListHeader(title = "Title", actionStr = "See all", action = {})
    }
}

@Preview
@Composable
fun ListHeaderIconPreview() {
    PersonalWalletTheme {
        ListHeader(title = "Title", icon = WalletIcons.SORT, action = {})
    }
}
