import retrofit2.OptionalConverterFactory
import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class JokeResponse(val value: String)

interface ApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeResponse
}

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(OptionalConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
