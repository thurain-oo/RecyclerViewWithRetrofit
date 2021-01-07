package com.example.recyclerviewwithretrofit.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithretrofit.ArticlesItem
import com.example.recyclerviewwithretrofit.databinding.CardViewItemBinding

/*
class BusinessAdapter(val context: BusinessFragment, val articles: List<ArticlesItem>):
RecyclerView.Adapter<BusinessAdapter.ArticleViewHolder>(){
    class ArticleViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val title : TextView = view.findViewById(R.id.card_view_text)
        val image : ImageView = view.findViewById(R.id.card_view_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_item,parent,false)
        return ArticleViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = articles[position]
        holder.title.text = item.title
       // holder.image.setImageResource(item.urlToImage)
    }

    override fun getItemCount(): Int {
        return articles.size
    }


}*/

class BusinessAdapter : ListAdapter<ArticlesItem,
        BusinessAdapter.ArticleItemViewHolder>(DiffCallback) {
    class ArticleItemViewHolder(private var binding:
                                CardViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            binding.article = article
            binding.executePendingBindings()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleItemViewHolder {
        return ArticleItemViewHolder(
            CardViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticleItemViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<ArticlesItem>() {
        override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem.title == newItem.title
        }
    }


}



