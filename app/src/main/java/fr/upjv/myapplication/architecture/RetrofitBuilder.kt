package fr.upjv.myapplication.architecture

import com.google.gson.GsonBuilder
import fr.upjv.myapplication.data.remote.ChuckNorrisQuoteEndpoint
import fr.upjv.myapplication.data.remote.FootballPlayerEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()



    private const val BASE_URL = "https://api.football-data.org/v4/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val footballPlayerEndpoint: FootballPlayerEndpoint by lazy {
        getRetrofit().create(FootballPlayerEndpoint::class.java)
    }


    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint = retrofit.create(ChuckNorrisQuoteEndpoint::class.java)
    /* fun getRandom(): FootballEndpoint = retrofit.create(FootballEndpoint::class.java) */




}
