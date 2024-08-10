package com.example.cs330_pz_3929

import android.content.Context
import androidx.room.Room
import com.example.cs330_pz_3929.DAO.ScoreDao
import com.example.cs330_pz_3929.DAO.UserDao
import com.example.cs330_pz_3929.Database.AppDatabase
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