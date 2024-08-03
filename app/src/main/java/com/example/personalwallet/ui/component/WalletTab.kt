package com.example.personalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.personalwallet.navigation.TopLevelDestination

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
        modifier = Modifier.height(TabHeight)
            .selectable(
                selected = isSelected,
                onClick = onSelect,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = icon,
            contentDescription = text
        )
        Text(text = text)
    }
}

@Composable
fun BottomTabRow(
    allScreens: List<TopLevelDestination>,
    onTabSelected: (TopLevelDestination) -> Unit,
    currentScreen: TopLevelDestination
) {
    Row(
        Modifier.height(TabHeight).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        allScreens.forEach { screen ->
            TabItem(
                text = screen.route,
                icon = screen.selectedIcon,
                onSelect = { onTabSelected(screen) },
                isSelected = currentScreen == screen
            )
        }
    }
}