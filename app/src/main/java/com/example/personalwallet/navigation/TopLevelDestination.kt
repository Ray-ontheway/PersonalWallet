package com.example.personalwallet.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.personalwallet.R
import com.example.personalwallet.ui.icon.WalletIcons

enum class TopLevelDestination (
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
    val route: String
) {
    DASHBOARD(
        selectedIcon = WalletIcons.DASHBOARD,
        unselectedIcon = WalletIcons.DASHBOARD,
        iconTextId = R.string.title_dashboard,
        titleTextId = R.string.title_dashboard,
        route = "dashboard"
    ),
    WALLET(
        selectedIcon = WalletIcons.WALLET,
        unselectedIcon = WalletIcons.WALLET,
        iconTextId = R.string.title_wallet,
        titleTextId = R.string.title_wallet,
        route = "wallet"
    ),
    SETTINGS(
        selectedIcon = WalletIcons.SETTINGS,
        unselectedIcon = WalletIcons.SETTINGS,
        iconTextId = R.string.title_settings,
        titleTextId = R.string.title_settings,
        route = "settings"
    ),
}