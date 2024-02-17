package com.example.kotlinretrofitmvvmclean.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinretrofitmvvmclean.data.api.QuotesApi
import com.example.kotlinretrofitmvvmclean.data.api.RetrofitHelper
import com.example.kotlinretrofitmvvmclean.presentation.view.viewModel.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getApiData()
viewModel.observeMovieLiveData().observe(this, Observer {

    Log.d("##ORBRV",it.toString())
})



    }
}