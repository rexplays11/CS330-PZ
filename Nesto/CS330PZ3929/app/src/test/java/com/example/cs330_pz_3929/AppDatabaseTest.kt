package com.example.cs330_pz_3929

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cs330_pz_3929.data.kolekcija.dao.ScoreDao
import com.example.cs330_pz_3929.data.kolekcija.dao.UserDao
import com.example.cs330_pz_3929.data.kolekcija.database.AppDatabase
import com.example.cs330_pz_3929.data.kolekcija.entity.Score
import com.example.cs330_pz_3929.data.kolekcija.entity.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var scoreDao: ScoreDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        userDao = db.userDao()
        scoreDao = db.scoreDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertAndGetUser() = runBlocking {
        val user = User(playerName = "Player1")
        userDao.insert(user)
        val users = userDao.getAllUsers()
        assertEquals(1, users.size)
        assertEquals("Player1", users[0].playerName)
    }

    @Test
    fun insertAndGetScore() = runBlocking {
        val score = Score(playerName = "Player1", score = 100)
        scoreDao.insert(score)
        val scores = getValue(scoreDao.getAllScores())
        assertEquals(1, scores.size)
        assertEquals(100, scores[0].score)
    }

    private fun <T> getValue(liveData: LiveData<T>): T {
        val latch = CountDownLatch(1)
        val data = arrayOfNulls<Any>(1)
        val observer = object : Observer<T> {
            override fun onChanged(t: T) {
                data[0] = t
                latch.countDown()
                liveData.removeObserver(this)
            }
        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)
        @Suppress("UNCHECKED_CAST")
        return data[0] as T
    }
}