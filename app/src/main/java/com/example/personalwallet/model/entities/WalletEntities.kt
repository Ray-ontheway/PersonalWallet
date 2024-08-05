package com.example.personalwallet.model.entities

import android.os.Build
import androidx.annotation.RequiresApi
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Entity
data class PrimaryType(
    @Id var id: Long = 0,
    val name: String,
    val description: String,
    val transactionCount: Int = 0,
    val totalAmount: Double = 0.0,
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val createAt: LocalDateTime = LocalDateTime.now(),
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val updateAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false,
)

@RequiresApi(Build.VERSION_CODES.O)
@Entity
data class SecondaryType (
    @Id var id: Long = 0,
    val name: String,
    val description: String,
    val transactionCount: Int = 0,
    val totalAmount: Double = 0.0,
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val createAt: LocalDateTime = LocalDateTime.now(),
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val updateAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false,
)

@Entity
data class TypeRelation(
    @Id var id: Long = 0,
    val primaryTypeId: Long,
    val secondaryTypeId: Long,
    val isDeleted: Boolean = false,
)

@RequiresApi(Build.VERSION_CODES.O)
@Entity
data class TransactionRecord(
    @Id var id: Long = 0,
    var uid: String,
    val secondaryTypeId: Long,
    val serverProvider: String? = "",
    val resId: Int,
    @Convert(converter = TransactionTypeConverter::class, dbType = Int::class)
    val transactionType: TransactionTypeEnum,
    val amount: Double = 0.0,
    val comment: String? = null,
    @Convert(converter = LocalDateTimeConverter::class, dbType = Long::class)
    val createAt: LocalDateTime = LocalDateTime.now(),
    @Convert(converter = LocalDateTimeConverter::class, dbType = Long::class)
    val updateAt: LocalDateTime = LocalDateTime.now(),
    var isImpulse: Boolean = false,
    var isDeleted: Boolean = false,
)

@RequiresApi(Build.VERSION_CODES.O)
@Entity
data class Wallet (
    @Id var id: Long = 0,
    val name: String,
    val description: String,
    val balance: Double = 0.0,
    val income: Double = 0.0,
    val expense: Double = 0.0,
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val createAt: LocalDateTime = LocalDateTime.now(),
    @Convert( converter = LocalDateTimeConverter::class, dbType = Long::class)
    val updateAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false,
)
