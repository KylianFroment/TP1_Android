package fr.upjv.myapplication.data.remote

import fr.upjv.myapplication.data.model.FootballPlayerEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface FootballPlayerEndpoint {
    @Headers("X-Auth-Token: 809f437617934ea2a42816570e5e1559") // Your API Key
    @GET("players")
    suspend fun getRandomPlayer(): Response<FootballPlayerEntity>
}
