package com.example.budgetmanagement.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CreditsDB :: class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun creditDao(): CreditDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            val tempInference = INSTANCE
            if (tempInference != null) {

                return tempInference
            }
            synchronized(this) {
                val instant = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instant
                return instant
            }
        }

    }

}