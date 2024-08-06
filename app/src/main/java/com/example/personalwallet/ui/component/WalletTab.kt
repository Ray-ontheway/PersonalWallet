package com.example.personalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.navigation.WalletDestination
import com.example.personalwallet.ui.icon.WalletIcons

private val TabHeight = 60.dp
private const val InactiveTabOpacity = 0.60f

@Composable
fun TabItem(
    text: String,
    icon: ImageVector,
    onSelect: () -> Unit,
    isSelected: Boolean
) {
    Column(
        modifier = Modifier
            .height(TabHeight)
            .selectable(
                selected = isSelected,
                onClick = onSelect,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
        )
        Text(text = text, fontSize = 20.sp, color = Color.Black)
    }
}

@Composable
fun BottomTabRow(
    allScreens: List<WalletDestination>,
    onTabSelected: (WalletDestination) -> Unit,
    currentScreen: WalletDestination
) {
    Row(
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
            .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        allScreens.forEach { screen ->
            TabItem(
                text = screen.route,
                icon = screen.selectedIcon!!,
                onSelect = { onTabSelected(screen) },
                isSelected = currentScreen == screen
            )
        }
    }
}

@Composable
fun WalletTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier.fillMaxWidth().height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(imageVector = WalletIcons.BACK, contentDescription = "Back")
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Image(imageVector = WalletIcons.OPTION, contentDescription = "System Settings")
    }
}

@Preview
@Composable
fun WalletTopBarPreview() {
    WalletTopBar(title = "Dashboard", modifier = Modifier.fillMaxWidth().background(color = Color.Magenta))
}