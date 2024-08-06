package com.example.personalwallet.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import com.example.personalwallet.viewmodel.MainViewModel

@Composable
fun SettingsRoute(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    SettingsScreen(modifier = modifier)
}

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    PersonalWalletTheme {
        Text(text = "Settings")
    }
}
