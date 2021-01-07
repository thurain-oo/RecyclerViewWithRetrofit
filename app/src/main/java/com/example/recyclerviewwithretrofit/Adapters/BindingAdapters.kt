package com.example.recyclerviewwithretrofit.Adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithretrofit.ArticlesItem


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<ArticlesItem>?) {
    val adapter = recyclerView.adapter as BusinessAdapter
 adapter.submitList(data)
}