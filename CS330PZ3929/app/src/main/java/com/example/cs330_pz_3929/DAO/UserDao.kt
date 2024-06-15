package com.example.cs330_pz_3929.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.cs330_pz_3929.Entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}