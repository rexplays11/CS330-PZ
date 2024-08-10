package com.example.cs330_pz_3929.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //HTTP GET zahtev koji preuzima podatke sa zadate putanje "/users/{userId}
    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): User2
}

// Ova klasa predstavlja strukturu korisničkih podataka koji će biti preuzeti sa servera.
data class User2(val id: Int, val username: String)
