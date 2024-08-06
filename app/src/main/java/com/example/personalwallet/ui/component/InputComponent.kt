package com.example.personalwallet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalwallet.R
import com.example.personalwallet.ui.icon.WalletIcons
import com.example.personalwallet.ui.theme.PersonalWalletTheme
import timber.log.Timber

@Composable
fun InputFieldWithEndIcon(
    value: String = "",
    onValueChange: (String) -> Unit,
    focus: Boolean = false,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .height(60.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp, 0.dp, 8.dp, 0.dp),
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Input Icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onValueChange("")
                    }
            )
        },

        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
fun InputFieldWithEndIconPreview() {
    PersonalWalletTheme {
        InputFieldWithEndIcon(value = "hell", onValueChange = { newValue ->
            Timber.d("New value: $newValue")
        })
    }
}


@Composable
fun IconButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick,
        modifier = modifier.padding(0.dp, 0.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp, 16.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFE7E8E9), Color.Black, Color.Gray, Color.LightGray),
    ) {
        Icon(imageVector = icon, contentDescription = "", modifier = Modifier.background(Color.Transparent, shape = RoundedCornerShape(50)))
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = text, fontSize = 24.sp, textAlign = TextAlign.Center, color = Color.Black)
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    PersonalWalletTheme {
        IconButton(icon = WalletIcons.ADD, text = "ADD", onClick = {})
    }
}