package com.example.personalwallet.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.personalwallet.ui.screen.DashboardScreen
import com.example.personalwallet.ui.screen.SettingsScreen
import com.example.personalwallet.ui.screen.WalletScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WalletNavHost(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = DASHBOARD.route,
        modifier = modifier
    ) {
        dashboardScreen(navHostController::gotoNewTransaction)
        walletScreen()
        settingsScreen()
        newTransactionScreen(navHostController::popBackStack)
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