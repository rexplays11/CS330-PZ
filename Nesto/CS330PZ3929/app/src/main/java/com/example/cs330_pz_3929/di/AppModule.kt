package com.example.cs330_pz_3929.di

import android.content.Context
import androidx.room.Room
import com.example.cs330_pz_3929.data.kolekcija.dao.ScoreDao
import com.example.cs330_pz_3929.data.kolekcija.dao.UserDao
import com.example.cs330_pz_3929.data.kolekcija.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "game_database"
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Provides
    fun provideScoreDao(db: AppDatabase): ScoreDao {
        return db.scoreDao()
    }
}