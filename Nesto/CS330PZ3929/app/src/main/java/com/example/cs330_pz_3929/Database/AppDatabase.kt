package com.example.cs330_pz_3929.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cs330_pz_3929.DAO.ScoreDao
import com.example.cs330_pz_3929.DAO.UserDao
import com.example.cs330_pz_3929.Entity.Score
import com.example.cs330_pz_3929.Entity.User



@Database(entities = [User::class, Score::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun scoreDao(): ScoreDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        // Funkcija za dobijanje instance baze podataka.
        // Ako instance nema, sinhronizuje se kreiranje nove instance baze.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "game_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}