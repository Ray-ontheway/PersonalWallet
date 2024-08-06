package com.example.personalwallet.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.personalwallet.R
import com.example.personalwallet.enums.TransactionTypeEnum
import com.example.personalwallet.getTransactionList
import com.example.personalwallet.model.vo.TransactionVO
import com.example.personalwallet.ui.component.IconButton
import com.example.personalwallet.ui.component.ListHeader
import com.example.personalwallet.ui.component.TransactionItem
import com.example.personalwallet.ui.icon.WalletIcons
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import com.example.personalwallet.viewmodel.MainViewModel
import timber.log.Timber

@Composable
fun FinancialSummary(
    income: Double = 0.0,
    expenses: Double = 0.0,
    totalBalance: Double = income - expenses,
    modifier: Modifier = Modifier
) {
    val rmbStr = stringResource(id = R.string.cny)
    Column(
        modifier = modifier
            .background(Color(0xFF1B5C58), shape = RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Text(
            text = "Total balance",
            fontSize = 18.sp,
            color = Color.White
        )
        Text(
            text = "$rmbStr $totalBalance",
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Income", fontSize = 16.sp, color = Color.White)

                Text(
                    text = "$rmbStr $income",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Expenses", fontSize = 16.sp, color = Color.White)
                Text(
                    text = "$rmbStr $income",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun FinancialSummaryPreview() {
    PersonalWalletTheme {
        FinancialSummary()
    }
}

@SuppressLint("ResourceType")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LatestTransactions(
    transactions: List<TransactionVO>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ListHeader(title = "Transactions history", action = { Timber.i("see all") })
        val data = if(transactions.size > 5) transactions.take(5) else transactions
        data.forEachIndexed { idx, transaction ->
            TransactionItem(
                resId = transaction.resId,
                transactionType = if (transaction.amount < 0) TransactionTypeEnum.EXPENSE else TransactionTypeEnum.INCOME,
                amount = transaction.amount,
                secondaryType = "Salary",
                serverProvider = transaction.serverProvider,
                createAt = transaction.createAt
            )
            if (idx < transactions.size - 1) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun GreetingHeader(
    username: String = "John Doe"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Greeting text
        Text(text = "Good afternoon,", fontSize = 20.sp, color = Color.White,)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "John Doe", fontSize = 36.sp, color = Color.White,)
    }
}

@Preview
@Composable
fun GreetingHeaderPreview() {
    GreetingHeader()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardRoute(
    onToNewTransactionClick: () -> Unit,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    DashboardScreen(
        toNewClick = onToNewTransactionClick,
        modifier = modifier,
    )
}

@SuppressLint("ResourceType")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(
    toNewClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingHeader()
        FinancialSummary()
        Spacer(modifier = Modifier.height(4.dp))
        LatestTransactions(transactions = getTransactionList())
        IconButton(icon = WalletIcons.ADD, text = "NEW", onClick = { toNewClick() }, modifier = Modifier
            .padding(0.dp, 0.dp)
            .fillMaxWidth(),)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun DashboardScreenPreview() {
    PersonalWalletTheme {
        DashboardScreen()
    }
}