package com.example.personalwallet

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.personalwallet.model.vo.TransactionVO
import com.example.personalwallet.navigation.ALL_NAVIGATION_DESTINATIONS
import com.example.personalwallet.navigation.DASHBOARD
import com.example.personalwallet.navigation.TOP_LEVEL_DESTINATIONS
import com.example.personalwallet.navigation.WalletNavHost
import com.example.personalwallet.navigation.isTopLevelDestination
import com.example.personalwallet.navigation.navigateSingleToTop
import com.example.personalwallet.ui.component.AppTopBar
import com.example.personalwallet.ui.component.BottomTabRow
import com.example.personalwallet.ui.component.WalletTopBar
import com.example.personalwallet.ui.theme.PersonalWalletTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT

        setContent {
            PersonalWalletTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = "Background",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .systemBarsPadding()
                    ) {
                        PersonalWalletApp()
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun PersonalWalletApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val currentBackstack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackstack?.destination
    val currentScreen = ALL_NAVIGATION_DESTINATIONS.find {
        it.route == currentDestination?.route
    } ?: DASHBOARD

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        bottomBar = {
            if (isTopLevelDestination(currentScreen)) {
                BottomTabRow(
                    allScreens = TOP_LEVEL_DESTINATIONS,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleToTop(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        }
    ) { innerPadding ->
        WalletNavHost(
            navHostController = navController,
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.Transparent)
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun getTransactionList(): List<TransactionVO> {
    val transactionList = mutableListOf<TransactionVO>()
    for (i in 1..10) {
        transactionList.add(
            TransactionVO(
                i.toLong(),
                "uid",
                "1",
                "Alipay",
                amount = 100.0,
                comment = "comment",
                isImpulse = false,
            )
        )
    }
    return transactionList
}
