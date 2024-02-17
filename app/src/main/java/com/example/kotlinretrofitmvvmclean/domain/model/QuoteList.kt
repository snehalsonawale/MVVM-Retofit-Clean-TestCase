package com.example.kotlinretrofitmvvmclean.domain.model

import com.example.kotlinretrofitmvvmclean.domain.model.Result

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val totalCount: Int,
    val totalPages: Int,
    val results: List<Result>,
)