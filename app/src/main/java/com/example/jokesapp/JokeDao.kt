//Interface for database operations
package com.example.jokesapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {
    @Insert
    suspend fun insert(joke: JokeEntity)

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): Flow<List<JokeEntity>>
}
