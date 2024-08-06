package com.example.personalwallet.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import com.example.personalwallet.viewmodel.MainViewModel

@Composable
fun WalletRoute(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    WalletScreen()
}

@Composable
fun WalletScreen(
    modifier: Modifier = Modifier,
) {
    PersonalWalletTheme {
        Text(text = "Wallet")
    }
}