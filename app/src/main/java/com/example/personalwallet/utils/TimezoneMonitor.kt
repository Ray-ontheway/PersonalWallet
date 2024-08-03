package com.example.personalwallet.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.TimeZone

interface TimezoneMonitor {
    val currentTimezone: Flow<TimeZone>
}