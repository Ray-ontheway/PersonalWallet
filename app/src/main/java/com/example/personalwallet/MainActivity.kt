package com.example.personalwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.ui.theme.PersonalWalletTheme

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

@Composable
fun TransactionItem(
    modifier: Modifier= Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFF2E7E79), shape = RoundedCornerShape(4.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .size(48.dp),
            contentDescription = ""
        )
        Column {
            Text(
                text = "Transaction title",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Transaction description",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun TransactionItemPreview() {
    PersonalWalletTheme {
        TransactionItem()
    }
}
