package com.example.recyclerviewwithretrofit.network

import com.example.recyclerviewwithretrofit.News
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL =
    "https://newsapi.org/v2/"

private val  gSon = GsonBuilder().create()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gSon))
    .baseUrl(BASE_URL)
    .build()
interface NewsApiService {
    @GET("top-headlines")
  suspend  fun getNewsWithCategory(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apikey") apiKey: String,

        ): News

    object AllNewsApi {
        val retrofitService : NewsApiService by lazy {
            retrofit.create(NewsApiService::class.java) }
    }

    @GET("everything")
    fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Call<News>
}