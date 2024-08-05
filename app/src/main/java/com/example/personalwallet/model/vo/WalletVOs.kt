package com.example.personalwallet.model.vo

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.personalwallet.R
import com.example.personalwallet.model.entities.LocalDateTimeConverter
import com.example.personalwallet.model.entities.PrimaryType
import io.objectbox.annotation.Convert
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
data class TransactionVO (
    val int: Long,
    var uid: String,
    val primaryType: String,
    val secondaryType: String,
    val serverProvider: String = "其他",
    val resId: Int = R.drawable.ic_launcher_foreground,
    val amount: Double,
    val comment: String? = null,
    val createAt: LocalDateTime = LocalDateTime.now(),
    val updateAt: LocalDateTime = LocalDateTime.now(),
    var isImpulse: Boolean = false,
)