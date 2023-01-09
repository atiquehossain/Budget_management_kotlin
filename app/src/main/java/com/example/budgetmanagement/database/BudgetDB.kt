package com.example.budgetmanagement.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CREDIT_TABLE")
data class DebitDB(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "creditSrc") val creditSrc: String,
    @ColumnInfo(name = "creditEntryDate") val creditEntryDate: String,
    @ColumnInfo(name = "creditAmount") val creditAmount: Int,
    @ColumnInfo(name = "creditsSum") val creditsSum: Int,
)

@Entity(tableName = "PAYMENT_TABLE")
data class PaymentDB(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "paymentReason") val payReason: String,
    @ColumnInfo(name = "paymentDate") val paymentDate: String,
    @ColumnInfo(name = "paymentAmount") val paymentAmount: Int,
    @ColumnInfo(name = "productPicture") val productPicture: String,
    @ColumnInfo(name = "PaymentNote") val PaymentNote: String,

)