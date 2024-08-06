package com.example.personalwallet.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.personalwallet.R
import com.example.personalwallet.ui.icon.WalletIcons
import com.example.personalwallet.ui.screen.DashboardRoute
import com.example.personalwallet.ui.screen.DashboardScreen
import com.example.personalwallet.ui.screen.NewRecordRoute
import com.example.personalwallet.ui.screen.NewRecordScreen
import com.example.personalwallet.ui.screen.SettingsScreen
import com.example.personalwallet.ui.screen.WalletScreen

data class WalletDestination (
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
    val route: String,
    @StringRes val text: Int,
    @StringRes val iconText: Int = -1,
)

@RequiresApi(Build.VERSION_CODES.O)
val DASHBOARD = WalletDestination(
    selectedIcon = WalletIcons.DASHBOARD,
    unselectedIcon = WalletIcons.DASHBOARD,
    route = "dashboard",
    text = R.string.title_dashboard,
    iconText = R.string.title_dashboard,
)
fun NavController.gotoNewTransaction() {
    navigate(NEW_TRANSACTION.route)
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.dashboardScreen(
    toNewClick: () -> Unit
) {
    composable(DASHBOARD.route) {
        DashboardRoute(onToNewTransactionClick = toNewClick)
    }
}

val WALLET_HISTORY = WalletDestination (
    selectedIcon = WalletIcons.WALLET,
    unselectedIcon = WalletIcons.WALLET,
    route = "wallet",
    text = R.string.title_wallet,
    iconText = R.string.title_wallet,
)
fun NavGraphBuilder.walletScreen() {
    composable(WALLET_HISTORY.route) {
        WalletScreen()
    }
}

val SETTINGS = WalletDestination (
    selectedIcon = WalletIcons.SETTINGS,
    unselectedIcon = WalletIcons.SETTINGS,
    route = "settings",
    text = R.string.title_settings,
    iconText = R.string.title_settings,
)
fun NavGraphBuilder.settingsScreen() {
    composable(SETTINGS.route) {
        SettingsScreen()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val TOP_LEVEL_DESTINATIONS = listOf<WalletDestination>(
    DASHBOARD, WALLET_HISTORY, SETTINGS
)

@RequiresApi(Build.VERSION_CODES.O)
fun isTopLevelDestination(destination: WalletDestination) =
    TOP_LEVEL_DESTINATIONS.contains(destination)

val NEW_TRANSACTION = WalletDestination (
    route = "settings",
    text = R.string.title_settings,
)
fun NavGraphBuilder.newTransactionScreen(
    onBackClick: () -> Unit
) {
    composable(NEW_TRANSACTION.route) {
        NewRecordRoute(onBackClick = onBackClick)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val ALL_NAVIGATION_DESTINATIONS = listOf<WalletDestination>(
    NEW_TRANSACTION, *TOP_LEVEL_DESTINATIONS.toTypedArray(),
)

