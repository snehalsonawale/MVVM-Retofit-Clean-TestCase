package com.example.kotlinretrofitmvvmclean.data.api

import com.example.kotlinretrofitmvvmclean.domain.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}