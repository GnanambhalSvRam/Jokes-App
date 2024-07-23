package com.example.jokesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val joke: String
)


//Data class to represent a joke in the database