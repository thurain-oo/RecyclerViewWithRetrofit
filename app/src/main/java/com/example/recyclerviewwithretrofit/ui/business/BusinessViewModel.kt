package com.example.recyclerviewwithretrofit.ui.business

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewwithretrofit.ArticlesItem
import com.example.recyclerviewwithretrofit.News
import com.example.recyclerviewwithretrofit.network.NewsApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BusinessViewModel : ViewModel() {
    private val _news= MutableLiveData<News>()

    val news: LiveData<News>
        get() = _news

    private val _articles= MutableLiveData<List<ArticlesItem>>()

    val articles: LiveData<List<ArticlesItem>>
        get() = _articles


    init {
        getNewsObject()
    }

    private fun getNewsObject() {/*
        NewsApiService.AllNewsApi.retrofitService.getNewsWithCategory(
            "us",
            "business",
            "7df5765e2e6e4d488372e5813e9225ab"
        ).enqueue(
            object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    _news.value = response.body()
                    _articles.value = _news.value?.articles as List<ArticlesItem>?

                }

                override fun onFailure(call: Call<News>, t: Throwable) {


                }
            })*/
        viewModelScope.launch {

            try {
                _news.value = NewsApiService.AllNewsApi.retrofitService.getNewsWithCategory(
                    "us",
                    "business",
                    "7df5765e2e6e4d488372e5813e9225ab"
                )
                _articles.value = _news.value?.articles as List<ArticlesItem>?



            } catch (e: Exception) {

            }
        }
    }

}