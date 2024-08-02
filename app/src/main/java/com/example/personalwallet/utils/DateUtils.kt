package com.example.personalwallet.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object DateUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(date: LocalDateTime, pattern: String): String {
        return date.format(DateTimeFormatter.ofPattern(pattern))
    }

}