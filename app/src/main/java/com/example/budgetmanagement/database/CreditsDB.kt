package com.example.budgetmanagement.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "CREDIT_TABLE")
    data class CreditsDB(

         @PrimaryKey(autoGenerate = true) val id: Int?,
         @ColumnInfo(name = "creditSrc") val creditSrc: String?,
         @ColumnInfo(name = "creditEntryDate") val creditEntryDate: String?,
         @ColumnInfo(name = "creditAmount") val creditAmount: Int?,
         @ColumnInfo(name = "creditsSum") val creditsSum: Int?,
)