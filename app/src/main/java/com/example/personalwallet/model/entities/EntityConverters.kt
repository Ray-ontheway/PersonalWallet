package com.example.personalwallet.model.entities

import android.os.Build
import androidx.annotation.RequiresApi
import io.objectbox.converter.PropertyConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class LocalDateTimeConverter : PropertyConverter<LocalDateTime, Long> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun convertToEntityProperty(databaseValue: Long): LocalDateTime {
        return LocalDateTime.ofEpochSecond(databaseValue, 0, ZoneOffset.UTC)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun convertToDatabaseValue(entityProperty: LocalDateTime): Long {
        return entityProperty.toEpochSecond(ZoneOffset.UTC)
    }
}

class TransactionTypeConverter : PropertyConverter<TransactionTypeEnum, Int> {
    override fun convertToEntityProperty(databaseValue: Int): TransactionTypeEnum {
        return TransactionTypeEnum.entries.first { it.value == databaseValue }
    }

    override fun convertToDatabaseValue(entityProperty: TransactionTypeEnum): Int {
        return entityProperty.value
    }
}