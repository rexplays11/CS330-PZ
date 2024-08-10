package com.example.cs330_pz_3929.data.kolekcija.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cs330_pz_3929.data.kolekcija.entity.User

@Dao
interface UserDao {
    //SQL upit za unos korisnika u bazi
    @Insert
    suspend fun insert(user: User)
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>
}