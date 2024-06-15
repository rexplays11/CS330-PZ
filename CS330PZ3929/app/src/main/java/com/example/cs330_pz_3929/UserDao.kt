package com.example.cs330_pz_3929

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}