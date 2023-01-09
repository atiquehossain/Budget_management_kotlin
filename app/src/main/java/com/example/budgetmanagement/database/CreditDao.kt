package com.example.budgetmanagement.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CreditDao {

    @Query("SELECT * FROM CREDIT_TABLE")
    fun getAll(): List<DebitDB>

    @Query("SELECT * FROM CREDIT_TABLE WHERE creditEntryDate LIKE :creditEntryDateTxt ")
     fun findByDate(creditEntryDateTxt: String): DebitDB

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(debitDB: DebitDB)

    @Delete
     fun delete(debitDB: DebitDB)

    @Query("DELETE FROM CREDIT_TABLE")
     fun deleteAll()
}