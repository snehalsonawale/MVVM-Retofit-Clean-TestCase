package com.example.kotlinretrofitmvvmclean.presentation.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinretrofitmvvmclean.data.api.QuotesApi
import com.example.kotlinretrofitmvvmclean.data.api.RetrofitHelper
import com.example.kotlinretrofitmvvmclean.domain.model.QuoteList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel  : ViewModel()
{

    private var movieLiveData = MutableLiveData<List<QuoteList>>()
     val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

    fun getApiData(){
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            {
                Log.d("##PRASH: ", result.body().toString())
                movieLiveData.postValue(listOf(result.body()) as List<QuoteList>?)
            }
        }
    }

    fun observeMovieLiveData() : LiveData<List<QuoteList>> {
        return movieLiveData
    }

}