package com.example.personalwallet

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.enums.TransactionTypeEnum
import com.example.personalwallet.model.vo.TransactionVO
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import com.example.personalwallet.utils.DateUtils
import timber.log.Timber
import java.time.LocalDateTime
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalWalletTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersonalWalletTheme {
        Greeting("Android")
    }
}


@Composable
fun FinancialSummary(
    income: Double = 0.0,
    expenses: Double = 0.0,
    totalBalance: Double = income - expenses,
    modifier: Modifier = Modifier
) {
    val rmbStr = stringResource(id = R.string.cny)
    Column (
        modifier = modifier
            .background(Color(0xFF2E7E79), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Total balance",
            fontSize = 16.sp,
            color = Color.White)
        Text(
            text = "$rmbStr $totalBalance",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Income", fontSize = 14.sp, color = Color.White)

                Text(text = "$rmbStr $income", fontSize = 20.sp, fontWeight = FontWeight(700), color = Color.White)
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Expenses", fontSize = 14.sp, color = Color.White)
                Text(text = "$rmbStr $income", fontSize = 20.sp,fontWeight = FontWeight(700), color = Color.White)
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
fun TransactionItem(
    @IdRes resId: Int = R.drawable.ic_launcher_foreground,
    transactionType: TransactionTypeEnum = TransactionTypeEnum.EXPENSE,
    amount: Double = 0.0,
    primaryType: String = "Income",
    secondaryType: String = "Salary",
    serverProvider: String = "Alipay",
    createAt: LocalDateTime = LocalDateTime.now(),
    modifier: Modifier= Modifier
) {
    Row(
        modifier = modifier
            .background(Color(0xFF2E7E79), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = resId),
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.size(4.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp)
        ) {
            val title = if (serverProvider.isNotBlank()) {
                "$secondaryType - $serverProvider"
            } else {
                secondaryType
            }
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                modifier = Modifier
            )

            Text(
                text = DateUtils.formatDate(createAt, "yyyy-MM-dd"),
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        val color = if (transactionType == TransactionTypeEnum.EXPENSE) {
            Color(0xFFE53E3E)
        } else {
            Color(0xFF38A169)
        }
        val amountStr = if (transactionType == TransactionTypeEnum.EXPENSE) {
            "- $amount"
        } else {
            "+ $amount"
        }
        Text(text = amountStr, fontSize = 18.sp, fontWeight = FontWeight(700), color = color, modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TransactionItemPreview() {
    PersonalWalletTheme {
        TransactionItem()
    }
}

@SuppressLint("ResourceType")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionList(
    transactions: List<TransactionVO>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(transactions) { transaction ->
            TransactionItem(
                resId = transaction.resId,
                transactionType = if (transaction.amount < 0) TransactionTypeEnum.EXPENSE else TransactionTypeEnum.INCOME,
                amount = transaction.amount,
                primaryType = "Income",
                secondaryType = "Salary",
                serverProvider = transaction.serverProvider ?: "",
                createAt = transaction.createAt
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun TransactionListPreview() {
    PersonalWalletTheme {
        TransactionList(getTransactionList())
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
                1,
                "Alipay",
                amount = 100.0,
                comment = "comment",
                isImpulse = false
            )
        )
    }
    return transactionList
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldWithEndIcon(
    value: String = "",
    onValueChange: (String) -> Unit,
    focus: Boolean = false,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(60.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .weight(1f),
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )
        )
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Input Icon")
    }
}

@Preview
@Composable
fun InputFieldWithEndIconPreview() {
    PersonalWalletTheme {
        InputFieldWithEndIcon( value = "hell", onValueChange = { newValue ->
            Timber.d("New value: $newValue")
        })
    }
}
