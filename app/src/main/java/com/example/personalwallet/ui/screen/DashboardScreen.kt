package com.example.personalwallet.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.personalwallet.ui.theme.PersonalWalletTheme

@Composable
fun DashboardScreen() {
    PersonalWalletTheme {
        Column {
            Text(text = "Dashboard")
        }
    }
}