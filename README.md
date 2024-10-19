# Jokes-App
A Kotlin app to retrieve, store, and display Chuck Norris jokes

**Instructions**
1. Start by creating an "empty activity" app that uses Compose (that's the default on the most recent version of Android Studio)
2. The app will need a button which will trigger a request to https://api.chucknorris.io/jokes/random which returns a random Chuck Norris joke.
3. Begin by displaying the most recent joke once you get a response.
4. Next, display all previous joke requests using a lazy list layout composable. Note, you'll want to use/create a viewmodel to track keep track of the jokes
5. Finally, add a Room database to store the jokes persistently so users don't lose old jokes when they close and reopen the app.

**References**
1. The UI: Scaffold - https://developer.android.com/develop/ui/compose/components/scaffold
2. The workflow - https://www.geeksforgeeks.org/how-to-make-a-joke-app-in-android-using-api-call/
3. Implementing the API service using retrofit (Network Layer) - Creating an API Service with Retrofit - https://medium.com/@imkuldeepsinghrai/api-calls-with-retrofit-in-android-kotlin-a-comprehensive-guide-e049e19deba9
4. Creating a database, data access object, and an entity (Database Layer) - https://developer.android.com/training/data-storage/room#kotlin
5. Room database setup - https://medium.com/@sdranju/step-by-step-how-to-setting-up-and-implementing-room-database-aeb211c56702
6. Creating a local data storage with Room - https://medium.com/huawei-developers/room-database-with-kotlin-mvvm-architecture-477c3ad3c264
7. Creating an instance: companion object - https://medium.com/@kamalvaid/room-using-kotlin-room-persistence-library-18a74f1ea16e
8. Stackoverflow for dependencies issues



