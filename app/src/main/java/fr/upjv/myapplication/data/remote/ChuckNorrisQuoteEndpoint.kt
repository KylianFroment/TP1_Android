package fr.upjv.myapplication.data.remote

import fr.upjv.myapplication.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {


    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}
