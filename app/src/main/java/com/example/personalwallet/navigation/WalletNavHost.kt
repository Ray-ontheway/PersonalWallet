package com.example.personalwallet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.personalwallet.ui.screen.DashboardScreen
import com.example.personalwallet.ui.screen.SettingsScreen
import com.example.personalwallet.ui.screen.WalletScreen


@Composable
fun WalletNavHost(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = TopLevelDestination.DASHBOARD.route,
        modifier = modifier
    ) {
        composable(route = TopLevelDestination.DASHBOARD.route) {
            DashboardScreen()
        }
        composable(route = TopLevelDestination.WALLET.route) {
            WalletScreen()
        }
        composable(route = TopLevelDestination.SETTINGS.route) {
            SettingsScreen()
        }
    }
}

fun NavHostController.navigateSingleToTop(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleToTop.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }