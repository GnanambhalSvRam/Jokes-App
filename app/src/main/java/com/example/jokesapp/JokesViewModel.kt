package com.example.jokesapp

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//class JokesViewModel : ViewModel() {
//    //private val _jokes = mutableStateListOf<String>()
//    private val _jokes = MutableStateFlow<List<String>>(emptyList())
//    //val jokes: List<String> = _jokes
//    val jokes: StateFlow<List<String>> = _jokes
//
//    fun fetchJoke() {
//        viewModelScope.launch {
//            try {
//                val retrofit = Retrofit.Builder()
//                    .baseUrl("https://api.chucknorris.io/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//
//                val api = retrofit.create(ApiService::class.java)
//                val response = api.getRandomJoke()
//                withContext(Dispatchers.Main) {
//                    //_jokes.add(response.value)
//                    _jokes.value += response.value
//
//                }
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    //_jokes.add("Failed to fetch joke!")
//                    _jokes.value += "Failed to fetch joke!"
//                }
//            }
//        }
//    }
//}

class JokesViewModel(application: Application) : AndroidViewModel(application) {
    private val jokeDao = AppDatabase.getDatabase(application).jokeDao()
    private val _jokes = MutableStateFlow<List<JokeEntity>>(emptyList())
    val jokes: StateFlow<List<JokeEntity>> = _jokes

    init {
        fetchAllJokes()
    }

    fun fetchJoke() {
        viewModelScope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.chucknorris.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val api = retrofit.create(ApiService::class.java)
                val response = api.getRandomJoke()
                val jokeEntity = JokeEntity(joke = response.value)
                jokeDao.insert(jokeEntity)
                fetchAllJokes()
            } catch (e: Exception) {
                val jokeEntity = JokeEntity(joke = "Failed to fetch joke!")
                jokeDao.insert(jokeEntity)
                fetchAllJokes()
            }
        }
    }

    private fun fetchAllJokes() {
        viewModelScope.launch {
            jokeDao.getAllJokes()
                .collect { jokeEntities ->
                    _jokes.value = jokeEntities
                }
        }
    }
}

interface ApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeResponse
}

data class JokeResponse(val value: String)
