package com.example.retrofitexample

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val  BASE_URL="https://newsapi.org/"
const val API_KEY="ff30357667f94aca9793cc35b9e447c1"

interface NewsInterface
{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getheadlines(@Query("country")country:String,@Query("page")page:Int):Call<News>
}

object  NewsService
{
    val newsInstance:NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}
