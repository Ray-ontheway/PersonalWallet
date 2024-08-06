package com.example.personalwallet.ui.component

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.R
import com.example.personalwallet.enums.TransactionTypeEnum
import com.example.personalwallet.getTransactionList
import com.example.personalwallet.model.vo.TransactionVO
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import com.example.personalwallet.utils.DateUtils
import java.time.LocalDateTime

@SuppressLint("ResourceType")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionItem(
    @IdRes resId: Int = R.drawable.ic_launcher_foreground,
    transactionType: TransactionTypeEnum = TransactionTypeEnum.EXPENSE,
    amount: Double = 0.0,
    secondaryType: String = "Salary",
    serverProvider: String = "Alipay",
    createAt: LocalDateTime = LocalDateTime.now(),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = resId),
            modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(Color.Gray),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.size(4.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp),
            verticalArrangement = Arrangement.Center
        ) {
            val title = if (serverProvider.isNotBlank()) {
                "$secondaryType - $serverProvider"
            } else {
                secondaryType
            }
            Text(
                text = title,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                modifier = Modifier
            )

            Text(
                text = DateUtils.formatDate(createAt, "yyyy-MM-dd"),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color.Black,
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
            "-$amount"
        } else {
            "+$amount"
        }
        Text(
            text = amountStr,
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = color,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
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
                secondaryType = "Salary",
                serverProvider = transaction.serverProvider,
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
