package com.example.personalwallet.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.FinancialSummary
import com.example.personalwallet.TransactionList
import com.example.personalwallet.getTransactionList

@SuppressLint("ResourceType")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp)
    ) {
        GreetingHeader()
        FinancialSummary()
        TransactionList(transactions = getTransactionList(), Modifier)
    }
}

@Composable
fun GreetingHeader(
    username: String = "John Doe"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Greeting text
        Text(text = "Good afternoon,", fontSize = 20.sp, color = Color.White,)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "John Doe", fontSize = 32.sp, color = Color.White,)
    }
}

@Preview
@Composable
fun GreetingHeaderPreview() {
    GreetingHeader()
}