package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.retrofitexample.MainActivity as MainActivity

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
    val news=NewsService.newsInstance.getheadlines("in",1)
        news.enqueue(object :Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Lavish","Error in fetching news")
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
               val news=response.body()
                if(news!=null)
                {
                    Log.d("Lavish",news.toString())
                    adapter= NewsAdapter(this@MainActivity,news.articles)
                    newslist.adapter=adapter
                    newslist.layoutManager= LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }
}