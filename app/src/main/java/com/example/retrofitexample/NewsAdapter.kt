package com.example.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context,val articles: List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>()
{

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
       var newsimage=itemView.findViewById<ImageView>(R.id.newsimage)
        var newstitle=itemView.findViewById<TextView>(R.id.newstitle)
        var newsdescription=itemView.findViewById<TextView>(R.id.newsdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        holder.newstitle.text=article.title
        holder.newsdescription.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsimage)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
        }
    }
}