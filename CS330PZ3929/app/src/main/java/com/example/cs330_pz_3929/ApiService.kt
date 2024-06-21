package com.example.cs330_pz_3929

import com.example.cs330_pz_3929.Entity.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): User2
}

// Primer entiteta User, prilagodite prema potrebama vašeg API-ja
data class User2(val id: Int, val username: String)
